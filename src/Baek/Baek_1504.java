package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 두 정점을 반드시 통과하는 최단거리 -> S - (v1, v2) - E
 * 1. 다익스트라
 * 2. 플루이드 워샬
 * */
public class Baek_1504 {
    static class node implements Comparable<node>{
        int V, cost;

        public node(int v, int cost) {
            V = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost - o.cost;
        }
    }
    static int N, E, V1, V2; // 정점의 개수, 간선의 개수
    static int[] D;
    static List<node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList [N + 1];
        D = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new node(b, c));
            graph[b].add(new node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        int sum1 = 0, sum2 = 0;
        sum1 += dijkstrra(1, V1) + dijkstrra(V1, V2) + dijkstrra(V2, N);
        sum2 += dijkstrra(1, V2) + dijkstrra(V2, V1) + dijkstrra(V1, N);

        int sum = Math.min(sum1, sum2);
        System.out.println(sum >= 200000000 || sum == 0 ? -1 : sum);
    }
    static int dijkstrra(int start, int end) {

        Arrays.fill(D, 200000000);

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(start, 0));
        D[start] = 0;

        while(!pq.isEmpty()) {
            node cur = pq.poll();

            // 현재까지의 cur.V 까지의 최단거리 < cur.V 까지의 비용
            // 더이상 진행할 필요 없음
            if(D[cur.V] < cur.cost) {
                continue;
            }

            for (int i = 0; i < graph[cur.V].size(); i++) {
                node next = graph[cur.V].get(i);

                if(D[next.V] > D[cur.V] + next.cost) {
                    D[next.V] = D[cur.V] + next.cost;
                    pq.offer(new node(next.V, D[next.V]));
                }
            }
        }
        return D[end];
    }
}
