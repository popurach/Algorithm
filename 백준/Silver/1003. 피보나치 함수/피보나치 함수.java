import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T, N;
    static int[][] dp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        dp = new int[41][2];
        for (int i = 0; i <= 40; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(dp[N][0] + " " + dp[N][1] + "\n");
        }
        System.out.println(sb);
    }
    static void fibonacci(int n) {
        dp[n][0] = 0;
        dp[n][1] = 0;
        if(n==0) {
            dp[n][0] += 1;
        } else if(n==1) {
            dp[n][1] += 1;
        } else {
            if(dp[n-1][0] == -1 || dp[n-1][1] == -1) {
                fibonacci(n-1);
            }
            dp[n][0] += dp[n-1][0];
            dp[n][1] += dp[n-1][1];

            if(dp[n-2][0] == -1 || dp[n-2][1] == -1) {
                fibonacci(n-2);
            }
            dp[n][0] += dp[n-2][0];
            dp[n][1] += dp[n-2][1];
        }
    }
}