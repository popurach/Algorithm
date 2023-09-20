import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class node {
        int idx, cost;

        public node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

    }
    static int n, m, r, max = 0; // 지역의 개수, 수색 범위(1<=m<=15), 길의 개수(1<=r<=100)
    static int[] item;
    static int[][] D;
    static List<node>[] list;
    static PriorityQueue<node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        item = new int[n + 1];
        D = new int[n + 1][n + 1];

        list = new ArrayList[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
            Arrays.fill(D[i], 10000);
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list[a].add(new node(b, l));
            list[b].add(new node(a, l));
        }

        pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        for (int i = 1; i <= n; i++) {
            D[i][i] = 0; // 출발지
            pq.offer(new node(i, 0));
            
            while (!pq.isEmpty()) {
                node cur = pq.poll();
                if(D[i][cur.idx] < cur.cost) {
                    continue;
                }
                for (int j = 0; j < list[cur.idx].size(); j++) {
                    node next = list[cur.idx].get(j);
                    if(D[i][next.idx] > D[i][cur.idx] + next.cost && D[i][cur.idx] + next.cost <= m) {
                        D[i][next.idx] = D[i][cur.idx] + next.cost;
                        pq.offer(new node(next.idx, D[i][next.idx]));
                    }
                }
            }
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if(D[i][j] <= m) {
                    sum += item[j];
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}