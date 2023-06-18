package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 플로이드 워샬 알고리즘
 * 경유지 -> (출발지 -> 도착지)
 * 최단경로 D[][] 2차원 배열을 통해 계산
 * */
public class Baek_1504_FloydWarshall {
    static class node {
        int V, cost;

        public node(int v, int cost) {
            V = v;
            this.cost = cost;
        }

    }
    static int N, E, V1, V2;
    static int[][] D;
    static List<node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        D = new int[N + 1][N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(D[i], 200000000);
            D[i][i] = 0;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            D[a][b] = c;
            D[b][a] = c;
            graph[a].add(new node(b, c));
            graph[b].add(new node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        floydWarshall();

        int sum1 = 0, sum2 = 0;
        sum1 += D[1][V1] + D[V1][V2] + D[V2][N];
        sum2 += D[1][V2] + D[V2][V1] + D[V1][N];

        int sum = Math.min(sum1, sum2);
        System.out.println(sum >= 200000000 || sum == 0 ? -1 : sum);
    }
    static void floydWarshall() {
        // 경유지 출발지 도착지
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if(i == k){
                    continue;
                }
                for (int j = 1; j <= N; j++) {
                    if(k == j || i == j || D[i][k] == 20000000 || D[k][j] == 200000000) {
                        continue;
                    }
                    if(D[i][j] > D[i][k] + D[k][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
    }
}
