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
        int nextNode;
        int cost;

        public node(int nextNode, int cost) {
            this.nextNode = nextNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost - o.cost;
        }

    }
    static int N, M;
    static int[] D;
    static List<node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList [N + 1];
        D = new int[N + 1];
        Arrays.fill(D, 100000000);

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new node(B, C));
            graph[B].add(new node(A, C));
        }
        dijkstra();
        System.out.println(D[N]);
    }
    static void dijkstra() {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(1, 0));
        D[1] = 0;

        while (!pq.isEmpty()) {
            node cur = pq.poll();
            if(D[cur.nextNode] < cur.cost) {
                continue;
            }
            for (int i = 0; i < graph[cur.nextNode].size(); i++) {
                node next = graph[cur.nextNode].get(i);
                if(D[next.nextNode] > D[cur.nextNode] + next.cost) {
                    D[next.nextNode] = D[cur.nextNode] + next.cost;
                    pq.offer(new node(next.nextNode, D[next.nextNode]));
                }
            }
        }
    }
}