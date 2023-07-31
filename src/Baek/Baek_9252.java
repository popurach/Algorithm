package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * LCS2
 * 최장증가문자열 찾는법
 * 가장 끝점에서 dp[i-1][j], dp[i][j-1]과 같은 값이 있다면 해당 위치로 이동
 * 같지 않다면 dp[i-1][j-1]로 이동하고 문자를 추가
 * 해당 문자열의 순서를 reverse 하고 출력
 * */
public class Baek_9252 {
    static int[][] dp;
    static StringBuilder temp = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = str1.length, j = str2.length;
        while(i > 0) {
            if(dp[i][j] == dp[i-1][j]) {
                i-=1;
            } else if(dp[i][j] == dp[i][j-1]) {
                j-=1;
            }else {
                i-=1;
                j-=1;
                temp.append(str1[i]);
            }
        }

        System.out.println(dp[str1.length][str2.length]);
        System.out.println(temp.reverse().toString());
    }
}
