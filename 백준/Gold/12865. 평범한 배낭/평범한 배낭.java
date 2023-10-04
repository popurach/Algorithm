import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;//물품의 수, 버틸 수 있는 무게
	static int[][] ob;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ob = new int[N + 1][2];
		dp = new int[N + 1][K + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			ob[i][0] = w;
			ob[i][1] = v;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j - ob[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - ob[i][0]] + ob[i][1]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		System.out.println(dp[N][K]);
	}
}
