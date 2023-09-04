import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, min = 1000000;
    static int[][] cost, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][3];
        dp = new int [N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            cost[i][0] = red;
            cost[i][1] = green;
            cost[i][2] = blue;

            Arrays.fill(dp[i], 1000000);
        }

        for (int i = 0; i < 3; i++) {
            dp[1][i] = cost[1][i];
            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + cost[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + cost[j][2];
            }
            min = Math.min(min, Math.min(dp[N][(i + 1) % 3], dp[N][(i + 2) % 3]));
            dp[1][i] = 1000000;
        }
        System.out.println(min);
    }
}