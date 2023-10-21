import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[i] = new int[]{a, b};
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(dfs(1, N));
    }
    static int dfs(int start, int end) {
        if(start == end) {
            return 0;
        } else if(dp[start][end] != Integer.MAX_VALUE) {
            return dp[start][end];
        }
        for (int i = start; i < end; i++) {
            int temp = matrix[start][0] * matrix[i][1] * matrix[end][1];
            dp[start][end] = Math.min(dp[start][end], dfs(start, i) + dfs(i + 1, end) + temp);
        }
        return dp[start][end];
    }
}