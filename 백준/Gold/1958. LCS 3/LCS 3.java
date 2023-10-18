import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 반례) 2개 문자열 LCS 후 나머지 문자열과 비교 시
 * s1 : abbbccc
 * s2 : bbbaddd
 * s3 : cccddda
 * LCS(s1, s2) -> bbb[1233333]
 * LCS(s2, s3) -> ddd[0001233]
 * but, LCS(s1, s2, s3) -> a
 * */
public class Main {
    static char[] arr1, arr2, arr3;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();
        arr3 = br.readLine().toCharArray();

        dp = new int[arr1.length + 1][arr2.length + 1][arr3.length + 1];

        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                for (int k = 1; k <= arr3.length; k++) {
                    if(arr1[i-1] == arr2[j-1] && arr2[j-1] == arr3[k-1]) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Integer.max(dp[i-1][j][k], Integer.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }

        System.out.println(dp[arr1.length][arr2.length][arr3.length]);
    }
}