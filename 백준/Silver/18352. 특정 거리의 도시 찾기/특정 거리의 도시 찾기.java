import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class node implements Comparable<node>{
        int V;
        int cost;

        public node(int v, int cost) {
            V = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost - o.cost;
        }
    }
    static int N, M, K, X, cnt = 0; // 도시 개수, 도로 개수, 거리 정보, 출발 번호
    static int[] D;
    static List<Integer> [] graph;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        D = new int[N + 1];
        Arrays.fill(D, 10000000);

        graph = new ArrayList [N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        dijkstra();

        for (int i = 1; i <= N; i++) {
            if(D[i] == K) {
                cnt++;
                sb.append(i + "\n");
            }
        }
        if(cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
    static void dijkstra() {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(X, 0));
        D[X] = 0;

        while(!pq.isEmpty()) {
            node cur = pq.poll();

            for (int i = 0; i < graph[cur.V].size(); i++) {
                int next = graph[cur.V].get(i);

                if(D[next] > cur.cost + 1) {
                    D[next] = cur.cost + 1;
                    pq.add(new node(next, cur.cost + 1));
                }
            }
        }
    }
}