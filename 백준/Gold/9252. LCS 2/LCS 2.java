import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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