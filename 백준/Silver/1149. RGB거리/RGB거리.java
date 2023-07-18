import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Top-Down 방식 풀이 (재귀함수 사용)
 * */
public class Main {
    static int N;
    static int[][] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][3];
        dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Math.min(knapsack(0, N), Math.min(knapsack(1, N), knapsack(2, N))));
    }
    static int knapsack(int num, int n) {
        if(dp[n][num] != -1) {
            return dp[n][num];
        }
        dp[n][num] = 0;
        int min = 1000;
        if(num == 0) {
            dp[n][num] = Math.min(knapsack(1, n-1) + graph[n][1], knapsack(2, n-1) + graph[n][2]);
        } else if(num == 1) {
            dp[n][num] = Math.min(knapsack(0, n-1) + graph[n][0], knapsack(2, n-1) + graph[n][2]);
        } else {
            dp[n][num] = Math.min(knapsack(0, n-1) + graph[n][0], knapsack(1, n-1) + graph[n][1]);
        }
        return dp[n][num];
    }
}