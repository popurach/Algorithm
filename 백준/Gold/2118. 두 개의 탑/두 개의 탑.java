import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, max = 0;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            memo[i] = memo[i-1] + Integer.parseInt(br.readLine());
        }

        for (int i = N; i >= 2; i--) {
            for (int j = i-1; j >= 1; j--) {
                int temp = memo[i] - memo[j];
                max = Math.max(max, Math.min(temp, memo[N] - temp));
            }
        }
        System.out.println(max);
    }
}