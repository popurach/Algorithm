package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 평범한 배낭
 * DP - 물건을 하나씩 넣는 것을 고려하면서 메모이제이션
 * */
public class Baek_12865 {
    static class product {
        int W, V;
        public product(int w, int v) {
            W = w;
            V = v;
        }
    }
    static int N, K;
    static List<product> list;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new product(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 1; i <= N; i++) {
            int weight = list.get(i - 1).W;
            int value = list.get(i - 1).V;
            for (int j = 1; j <= K; j++) {
                if(j >= weight) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
