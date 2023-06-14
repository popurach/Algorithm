import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int M, N; //가로크기, 세로크기
    static int[][] graph, d, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        d = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            Arrays.fill(d[i], Integer.MAX_VALUE);
            for (int j = 1; j <= M; j++) {
                graph[i][j] = temp.charAt(j - 1) - '0';
            }
        }
        bfs();
        System.out.println(d[N][M]);
    }
    static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{1, 1});
        d[1][1] = 0;

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();

            // 종료 조건
            if(cur[0] == N && cur[1] == M) {
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int ni = cur[0] + dir[i][0];
                int nj = cur[1] + dir[i][1];

                if(ni<1 || ni>N || nj<1 || nj>M) {
                    continue;
                }
                if(graph[ni][nj] == 0 &&  d[ni][nj] > d[cur[0]][cur[1]]) {
                    d[ni][nj] = d[cur[0]][cur[1]];
                    dq.offerFirst(new int[] {ni, nj});
                }
                if(graph[ni][nj] == 1 &&  d[ni][nj] > d[cur[0]][cur[1]] + 1) {
                    d[ni][nj] = d[cur[0]][cur[1]] + 1;
                    dq.offer(new int[] {ni, nj});
                }
            }
        }
    }
}