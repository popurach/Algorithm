import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] coin = { 2, 5 }, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = -1;
		dp[2] = 1;
		dp[3] = -1;
		dp[4] = 2;
		dp[5] = 1;
		if (n > 5) {
			for (int i = 6; i <= n; i++) {
				if(dp[i-2] == -1 && dp[i-5] == -1) {
					dp[i] = -1;
				}else if (dp[i - 2] == -1) {
					dp[i] = dp[i - 5] + 1;
				} else if (dp[i - 5] == -1) {
					dp[i] = dp[i - 2] + 1;
				} else {
					dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
				}
			}
		}
		System.out.println(dp[n]);
	}
}
