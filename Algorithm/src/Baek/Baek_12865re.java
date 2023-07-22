package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 평범한 배낭
 * dp -> 같은 물건을 여러번 집어 넣을 수 없으므로 dp 2차원 배열을 사용하는 것이 쉬움
 * W : 무게, V : 가치
 * 일차원 배열 해결법 이해 안됨 X, 연구 필요,,,
 * */
public class Baek_12865re {
    static int N, K;
    static int[] W, V, d;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];
        d = new int[K + 1];
        W = new int[N + 1];
        V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= K; j++) {
//                if(j >= W[i]) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        System.out.println(dp[N][K]);

        for (int i = 1; i <= N; i++) {
            for (int j = K - W[i]; j <= K; j++) {
                if(j - W[i] >= 0) {
                    d[j] = Math.max(d[j], d[j - W[i]] + V[i]);
                }
            }
        }
        System.out.println(d[K]);
    }
}
