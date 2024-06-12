import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt = 0;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i + 1][j + 1] = str.charAt(j);
            }
        }
        bfs();
        System.out.println(cnt);
    }
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[N + 1][M + 1];

        q.offer(new int[]{1, 1, 1});
        isVisited[1][1] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == N && cur[1] == M) {
                cnt = cur[2];
                return;
            }
            for (int i = 0; i < dir.length; i++) {
                int ni = cur[0] + dir[i][0];
                int nj = cur[1] + dir[i][1];

                if(ni < 1 || nj < 1 || ni > N || nj > M) {
                    continue;
                }
                if(arr[ni][nj] == '1' && !isVisited[ni][nj]) {
                    q.offer(new int[]{ni, nj, cur[2] + 1});
                    isVisited[ni][nj] = true;
                }
            }
        }
    }
}