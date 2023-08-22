package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 제곱수의 합
 * 어떤 자연수 N을 그보다 작거나 같은 제곱수들의 합으로 나타낼 때, 제곱수 항의 최소 개수 구하기
 * dp -> Math.min(현재 dp[N] 값, dp[N - 제곱수] + 1)
 * */
public class Baek_1699 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        for (int i = 1; i*i <= N; i++) {
            dp[i*i] = 1;
        }

        System.out.println(getNum(N));
    }
    static int getNum(int num) {
        if(dp[num] == 0) {
            dp[num] = N;
            for (int i = (int)Math.sqrt(num); i >= 1; i--) {
                dp[num] = Math.min(dp[num], getNum(num - (int)Math.pow(i, 2)) + 1);
            }
        }
        return dp[num];
    }
}