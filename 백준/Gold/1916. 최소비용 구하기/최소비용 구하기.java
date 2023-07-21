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
        int value;
        long cost;

        public node(int value, long cost) {
            this.value = value;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return (int)(this.cost - o.cost);
        }

    }
    static int N, M, start, end;
    static long[] D;
    static List<node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        D = new long[N + 1];
        Arrays.fill(D, 10000000000L);

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(D[end]);
    }
    static void dijkstra() {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(start, 0));
        D[start] = 0;
        while(!pq.isEmpty()) {
            node cur = pq.poll();

            if(D[cur.value] < cur.cost) {
                continue;
            }
            for (int i = 0; i < graph[cur.value].size(); i++) {
                node next = graph[cur.value].get(i);
                if(D[next.value] > D[cur.value] + next.cost) {
                    D[next.value] = D[cur.value] + next.cost;
                    pq.offer(new node(next.value, D[next.value]));
                }
            }
        }
    }
}