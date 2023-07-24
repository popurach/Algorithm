package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 동전
 * 여러 동전들로 특정 액수를 만들 수 있는
 * 경우의 수 구하기
 * */
public class Baek_9084 {
    static int T, N, M; // 테스트 케이스, 동전의 가지수, 만들어야 할 금액
    static int[] dp;
    static List<Integer> money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            money = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                money.add(Integer.parseInt(st.nextToken()));
            }
            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            for (int i = 0; i < N; i++) {
                int curMoney = money.get(i);
                for (int j = 1; j <= M; j++) {
                    // 현재 동전 값 보다 큰 액수라면
                    // 현재 액수의 경우의 수 + 차액(현재 액수 - 현재 동전 값)의 경우의 수
                    if(j > curMoney) {
                        dp[j] = dp[j] + dp[j - curMoney];
                    } else if(curMoney == j) {
                        dp[j] += 1;
                    }
                }
            }
            sb.append(dp[M] + "\n");
        }
        System.out.println(sb);
    }
}
