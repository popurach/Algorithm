import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        graph = new int [N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            graph[big][small] = 1;
            graph[small][big] = -1;
        }

        for (int k = 1; k <= N; k++) { //경유지
            for (int i = 1; i <= N; i++) { // 출발지
                if(k == i || graph[i][k] == 0) {
                    continue;
                }
                for (int j = 1; j <= N; j++) { // 도착지
                    if(k == j || i == j || graph[k][j] == 0) {
                        continue;
                    }
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    } else if(graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if(i == j) {
                    continue;
                }
                if(graph[i][j] == 0) {
                    cnt += 1;
                }
            }
            arr[i] = cnt;
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(arr[i]);
        }
    }
}