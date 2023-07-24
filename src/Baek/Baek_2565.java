package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 전깃줄 A전봇대와 B전봇대에 연결되어 있는 전깃줄이 있을 떄
 * 최대의 전깃줄이 겹치지 않게 -> 끊어야 하는 전깃줄의 수
 * DP
 * A전봇대 기준으로 정렬 -> LIS(최장 증가 부분 수열)
 * */
public class Baek_2565 {
    static int N;
    static int[] dp;
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[501];
        list = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        // A 전봇대 기준으로 정렬
        list.sort((a, b) -> a[0] - b[0]);

        int max = 0;
        for (int i = 0; i < N; i++) {
            int[] cur = list.get(i);
            // 해당 위치에 전깃줄 하나 설치 가능
            dp[cur[0]] = 1;
            // 이전 전깃줄 중 B 전봇대 값이 현재 보다 작다면
            for (int j = 0; j < i; j++) {
                int[] prev = list.get(j);
                if(cur[1] > prev[1]) {
                    dp[cur[0]] = Math.max(dp[cur[0]], dp[prev[0]] + 1);
                }
            }
            max = Math.max(max, dp[cur[0]]);
        }
        System.out.println(N - max);
    }
}
