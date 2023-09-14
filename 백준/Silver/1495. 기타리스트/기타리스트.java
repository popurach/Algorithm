import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {
    static int N, S, M;
    static int[] V;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        V = new int[N + 1];
        dp = new int[2][M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][S] = 1;
        int cur = 0, next = 0;
        for (int i = 1; i <= N; i++) {
            cur = i % 2 == 1? 0: 1;
            next = (cur + 1) % 2;
            for (int j = 0; j <= M; j++) {
                if(dp[cur][j] == 1) {
                    if(j + V[i] >= 0 && j + V[i] <= M){
                        dp[next][j + V[i]] = 1;
                    }
                    if(j - V[i] >= 0 && j - V[i] <= M) {
                        dp[next][j - V[i]] = 1;
                    }
                    dp[cur][j] = 0;
                }
            }
        }
        int answer = -1;
        for (int i = M; i >= 0; i--) {
            if(dp[next][i] == 1) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}