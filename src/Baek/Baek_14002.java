package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 가장 긴 증가하는 부분 수열 4
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열
 * dp -> 최고 크기 max 구한 후
 * 마지막 인덱스부터 이전 인덱스의 최대값 저장하며 sb에 저장
 * sb.toString().trim().split(" ");
 * */
public class Baek_14002 {
    static int N, max = 1;
    static int[] A, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            int temp = -1;
            for (int j = 0; j < i; j++) {
                if(A[i] > A[j]) {
                    temp = Math.max(temp, dp[j] + 1);
                }
            }
            dp[i] = (temp == -1)? 1: temp;
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
        // ** prev 값을 지정해줄 필요 없음 **
        // 해당 dp값이 max일 때 이전 max 보다 작다는 것이 보장됨
//        int prev = 0, idx = max;
//        for (int i = N-1; i >= 0; i--) {
//            if(dp[i] == idx) {
//                if(prev == 0) {
//                    prev = A[i];
//                } else {
//                    if(A[i] >= prev) {
//                        continue;
//                    }
//                    prev = A[i];
//                }
//                sb.append(A[i] + " ");
//                idx -= 1;
//            }
//        }
        for (int i = N-1; i >= 0; i--) {
            if(dp[i] == max) {
                sb.append(A[i] + " ");
                max -= 1;
            }
        }
        String[] str = sb.toString().trim().split(" ");
        sb.setLength(0);
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i] + " ");
        }
        System.out.println(sb);
    }
}
