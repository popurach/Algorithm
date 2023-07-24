import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class node implements Comparable<node>{
        int node, cost;

        public node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost - o.cost;
        }

    }
    static int n, m, s, e;
    static int[] D;
    static List<node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        D = new int[n + 1];
        Arrays.fill(D, 500000);

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new node(end, cost));
            list[end].add(new node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(D[e]);
    }
    static void dijkstra() {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(s, 0));
        D[s] = 0;

        while(!pq.isEmpty()) {
            node cur = pq.poll();
            for (int i = 0; i < list[cur.node].size(); i++) {
                node next = list[cur.node].get(i);
                if(D[next.node] <= next.cost) {
                    continue;
                }
                if(D[next.node] > D[cur.node] + next.cost) {
                    D[next.node] = D[cur.node] + next.cost;
                    pq.offer(new node(next.node, D[next.node]));
                }
            }
        }
    }
}