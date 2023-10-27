import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] stairs, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = stairs[1];
        if(N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        System.out.println(getDp(N));
    }
    static int getDp(int n) {
        if(n <= 2) {
            return dp[n];
        }
        if(dp[n] == 0) {
            dp[n] = Integer.max(getDp(n - 2), stairs[n - 1] + getDp(n - 3)) + stairs[n];
        }
        return dp[n];
    }
}