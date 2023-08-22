package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * dp 이용
 * dp[N + 1][10] 에서
 * dp[i][j] <- dp[i-1][[j] + dp[i][j+1]
 * 본인보다 같은 수로 끝나는 모든 경우의 수 + 본인보다 작은 수로 끝나는 모든 경우의 수
 */
//public class Baek_11057 {
//    static int N;
//    static int[][] dp;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        dp = new int[N + 1][10];
//        Arrays.fill(dp[1], 1);
//
//        for (int i = 2; i <= N; i++) {
//            dp[i][9] = 1;
//            for (int j = 8; j >= 0; j--) {
//                dp[i][j] = dp[i-1][j] + dp[i][j + 1];
//                if(dp[i][j] > 10007) {
//                    dp[i][j] %= 10007;
//                }
//            }
//        }
//        int sum = 0;
//        for (int i = 0; i <= 9; i++) {
//            sum += dp[N][i];
//            sum %= 10007;
//        }
//        System.out.println(sum);
//    }
//}

/**
 * 오르막 수 -> 인접한 수가 같아도 오름차순
 * abcd -> a<=b<=c<=d  (0, 9)의 수에서 중복을 허용해서 4개를 선택
 * 울타리 9개 => 9 + 4 C 4 = 13 C 4
 * */
public class Baek_11057 {
    static int N;
    static int[][] pascal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pascal = new int[10 + N][10 + N];
        pascal[0][0] = 1;

        for (int i = 1; i < 10 + N; i++) {
            pascal[i][0] = pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                if(pascal[i][j] > 10007) {
                    pascal[i][j] %= 10007;
                }
            }
        }
        System.out.println(pascal[9 + N][N]);
    }
}
