import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] weight, answer;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][40001];
        weight = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            dp[i][weight[i]] = 1;
            for (int j = 1; j <= 40000; j++) {
                if(dp[i-1][j] == 1) {
                    dp[i][j] = 1;
                    dp[i][j + weight[i]] = 1;
                    dp[i][Math.abs(weight[i] - j)] = 1;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            if(dp[N][answer[i]] == 1) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }
}