import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] graph, dpW, dpB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        dpW = new int[N + 1][M + 1];
        dpB = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                if(str.charAt(j-1) == 'B') {
                    graph[i][j] = 1;
                } else {
                    graph[i][j] = 0;
                }

                // dpW
                dpW[i][j] = dpW[i-1][j] + dpW[i][j-1] - dpW[i-1][j-1];
                if((i + j) % 2 == 0 && graph[i][j] == 1) { // W가 나와야 할 때
                    dpW[i][j] += 1;
                } else if((i + j) % 2 != 0 && graph[i][j] == 0) { // B가 나와야 할 때
                    dpW[i][j] += 1;
                }

                // dpB
                dpB[i][j] = dpB[i-1][j] + dpB[i][j-1] - dpB[i-1][j-1];
                if((i + j) % 2 == 0 && graph[i][j] == 0) { // B가 나와야 할 때
                    dpB[i][j] += 1;
                } else if((i + j) % 2 != 0 && graph[i][j] == 1) { // W가 나와야 할 때
                    dpB[i][j] += 1;
                }
            }
        }
        int min = N * M;
        for (int i = K; i <=N ; i++) {
            for (int j = K; j <= M; j++) {
                int sum1 = dpW[i][j] - dpW[i-K][j] - dpW[i][j-K] + dpW[i-K][j-K];
                int sum2 = dpB[i][j] - dpB[i-K][j] - dpB[i][j-K] + dpB[i-K][j-K];
                min = Math.min(min, Math.min(sum1, sum2));
            }
        }
        System.out.println(min);
    }
}