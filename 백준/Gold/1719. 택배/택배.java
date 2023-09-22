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
    static int n, m;
    static int[][] D, answer;
    static List<node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        D = new int [n+1][n+1];
        answer = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            Arrays.fill(D[i], 10000);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new node(b, c));
            list[b].add(new node(a, c));
        }

        PriorityQueue<node> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.cost, y.cost));
        for (int i = 1; i <= n; i++) {
            D[i][i] = 0;
            pq.offer(new node(i, 0));
            while(!pq.isEmpty()) {
                node cur = pq.poll();
                if(cur.cost > D[i][cur.idx]) {
                    continue;
                }
                for (int j = 0; j < list[cur.idx].size(); j++) {
                    node next = list[cur.idx].get(j);
                    if(D[i][next.idx] > D[i][cur.idx] + next.cost) {
                        D[i][next.idx] = D[i][cur.idx] + next.cost;
                        pq.offer(new node(next.idx, D[i][next.idx]));
                        answer[next.idx][i] = cur.idx;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) {
                    sb.append("- ");
                } else {
                    sb.append(answer[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}