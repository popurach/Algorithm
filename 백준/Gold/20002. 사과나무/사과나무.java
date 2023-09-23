import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max = -1000;
    static int[][] graph, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        D = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, graph[i][j]);
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + graph[i][j];
            }
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                int idx = i>j? j: i;
                for (int k = 2; k <= idx; k++) {
                    max = Math.max(max, D[i][j] - D[i-k][j] - D[i][j-k] + D[i-k][j-k]);
                }
            }
        }
        System.out.println(max);
    }
}