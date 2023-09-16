import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y, K;
    static int[] d;
    static int[][] dice, graph, dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        dice = new int[4][3];
        int curY = 3, curX = 1;

        for (int i = 0; i < K; i++) {
            int ni = x + dir[d[i]][0];
            int nj = y + dir[d[i]][1];

            if(ni < 0 || nj <0 || ni >= N || nj >= M) {
                continue;
            }
            x = ni;
            y = nj;
            // 주사위 이동
            int top = dice[1][1];
            if(d[i] == 1) { // 우
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = dice[1][2];
                dice[1][2] = top;
            } else if (d[i] == 2){ // 좌
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = dice[1][0];
                dice[1][0] = top;
            } else if(d[i] == 3) { // 상
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = dice[0][1];
                dice[0][1] = top;
            } else { // 하
                dice[1][1] = dice[0][1];
                dice[0][1] = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = top;
            }
            if(graph[ni][nj] == 0) {
                graph[ni][nj] = dice[3][1];
            } else {
                dice[3][1] = graph[ni][nj];
                graph[ni][nj] = 0;
            }
            sb.append(dice[1][1] + "\n");
        }
        System.out.println(sb);
    }
}