import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static List<Integer> money;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            money = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                money.add(Integer.parseInt(st.nextToken()));
            }
            M = Integer.parseInt(br.readLine());
            dp = new long[M + 1];
            knapsack();
            sb.append(dp[M] + "\n");
        }
        System.out.println(sb);
    }
    static void knapsack() {
        for (int i = 0; i < N; i++) {
            int curMoney = money.get(i);
            for (int j = 1; j <= M; j++) {
                if(j - curMoney > 0) {
                    dp[j] = dp[j] + dp[j - curMoney];
                } else if(j - curMoney == 0){
                    dp[j] += 1;
                }
            }
        }
    }
}