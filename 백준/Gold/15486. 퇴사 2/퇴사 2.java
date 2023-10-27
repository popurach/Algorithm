import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] T, P, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.max(dp[i], dp[i-1]);
            if(i + T[i] - 1 <= N) {
                dp[i + T[i] - 1] = Integer.max(dp[i + T[i] - 1], dp[i-1] + P[i]);
            }
//            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[N]);
    }
}