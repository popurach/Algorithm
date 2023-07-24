package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 플로이드
 * 플로이드 워샬 알고리즘 + 그래프 이론
 * */
public class Baek_11404 {
    static int n, m;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(graph[i], 100000000);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
        }

        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) { // 출발지
                if(i==k) {
                    continue;
                }
                for (int j = 1; j <= n; j++) { // 도착지
                    if(j==k || i==j) {
                        continue;
                    }
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == 100000000) {
                    sb.append(0 + " ");
                } else {
                    sb.append(graph[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
