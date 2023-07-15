import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파이프 옮기기 1
 * */
public class Main {
    static int N, cnt = 0;
    static int[][] graph, dir = {{0, 1}, {1, 0}, {1, 1}};
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3]; // 0:가로  1:세로  2:대각선
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][2][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if(graph[i][j] == 0) { // 가로
                    dp[i][j][0] += (dp[i][j-1][0] + dp[i][j-1][2]);
                }
                if(i - 1 >= 1 && graph[i][j] == 0) { // 세로
                    dp[i][j][1] += (dp[i-1][j][1] + dp[i-1][j][2]);
                }
                if(i -1 >= 1 && graph[i][j] == 0 && graph[i-1][j] == 0 && graph[i][j-1] == 0) { // 대각선
                    dp[i][j][2] += (dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]);
                }
            }
        }
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}