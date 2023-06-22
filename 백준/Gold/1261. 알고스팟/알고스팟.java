import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 미로에서 도착 지점까지 가는 최소 벽을 부수는 경우의 수
 * Priority Queue 이용 -> 벽을 깬 횟수를 정렬 기준
 * */
public class Main {
    static int N, M;
    static int[][] graph, D, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        D = new int[N][M]; // 벽을 부순 횟수

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            Arrays.fill(D[i], 10000);
            for (int j = 0; j < M; j++) {
                graph[i][j] = temp.charAt(j) - '0';
            }
        }
        bfs();
    }
    static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});
        D[0][0] = 0;

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            if(cur[0] == N - 1 && cur[1] == M - 1) {
                System.out.println(D[N-1][M-1]);
                return;
            }
            for (int i = 0; i < dir.length; i++) {
                int ni = cur[0] + dir[i][0];
                int nj = cur[1] + dir[i][1];
                if(ni < 0 || nj < 0 || ni > N-1 || nj > M-1) {
                    continue;
                }
                if(graph[ni][nj] == 0) {
                    if(D[ni][nj] > D[cur[0]][cur[1]]) {
                        D[ni][nj] = D[cur[0]][cur[1]];
                        dq.offerFirst(new int[]{ni, nj});
                    }
                } else {
                    if(D[ni][nj] > D[cur[0]][cur[1]] + 1) {
                        D[ni][nj] = D[cur[0]][cur[1]] + 1;
                        dq.offer(new int[]{ni, nj});
                    }
                }
            }
        }
    }
}