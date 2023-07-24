package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 포도주 시식
 * 1부터 n까지의 포도주를 마실 때, 연속으로 놓인 3잔을 모두 마실 수 없음
 * 최대 마실 수 있는 포도주 양
 * dp : Bottom-Up 방식 (반복문 구현)
 *
 * 1. 이차원 dp 사용
 * 0 : 현재 연속 0개  /  1 : 현재 연속 1개  /  2 : 현재 연속 2개
 * Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]))
 *
 * 2. 일차원 d 사용
 * Math.max(d[i-1], Math.max(d[i-2] + arr[i], d[i-3] + arr[i-1] + arr[i]))
 * d[i-1] : 현재 연속 0개
 * d[i-2] + arr[i] : 현재 연속 1개
 * d[i-3] + arr[i-1] + arr[i] : 현재 연속 2개
 * */
public class Baek_2156 {
    static int n;
    static int[] arr, d;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        d = new int[n + 1];
        dp = new int[n + 1][3]; // 0: 선택x  1: 선택o

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        d[1] = arr[1];
        if(n > 1) {
            d[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(d[i-1], Math.max(d[i-2] + arr[i], d[i-3] + arr[i-1] + arr[i]));
        }
        System.out.println(d[n]);
//        for (int i = 1; i <= n; i++) {
//            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
//            dp[i][1] = dp[i-1][0] + arr[i];
//            dp[i][2] = dp[i-1][1] + arr[i];
//        }
//        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
    }
}
