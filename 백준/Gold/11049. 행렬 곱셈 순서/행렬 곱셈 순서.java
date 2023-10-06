import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][2];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[i] = new int[]{r, c};
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        System.out.println(Knapsack(1, N));
    }
    static int Knapsack(int pos, int cur) {
        if(pos == cur) {
            return 0;
        }
        if(dp[pos][cur] != Integer.MAX_VALUE) {
            return dp[pos][cur];
        }

        for (int i = pos; i < cur; i++) {
            int value = Knapsack(pos, i) + Knapsack(i + 1, cur)
                    + graph[pos][0] * graph[i][1] * graph[cur][1];
            dp[pos][cur] = Integer.min(dp[pos][cur], value);
        }
        return dp[pos][cur];
    }
}