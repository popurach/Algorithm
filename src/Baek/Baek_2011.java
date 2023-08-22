package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 암호코드
 * A : 1, B : 2, ... , Z : 26
 * 문자를 암호화 할 때 암호의 해석이 나올 수 있는 경우의 수
 * arr[i] == 0이면 dp[i] = 0
 * arr[i] * 10 + arr[i + 1] <= 26이면 dp[i] = dp[i+1] + dp[i+2]
 * */
public class Baek_2011 {
    static String str;
    static char[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        arr = str.toCharArray();
        dp = new int[str.length() + 1];

        dp[str.length()] = 1;
        if(str.charAt(str.length() - 1) - '0' != 0) {
            dp[str.length() - 1] = 1;
        }
        for (int i = str.length() - 2; i >= 0; i--) {
            if(str.charAt(i) - '0' == 0) {
                continue;
            }
            dp[i] += dp[i + 1];
            int num = (str.charAt(i) - '0') * 10 + (str.charAt(i+1) - '0');
            if(num <= 26) {
                dp[i] += dp[i + 2];
            }
            dp[i] %= 1000000;
        }
        System.out.println(dp[0]);
    }
}
