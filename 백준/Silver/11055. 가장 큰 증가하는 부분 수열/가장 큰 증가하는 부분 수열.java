import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 가장 큰 증가하는 부분 수열
 * */
public class Main {
    static int N, max = 1;
    static int[] A, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < i; j++) {
                if(A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
            if(dp[i] == 0) {
                dp[i] = A[i];
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}