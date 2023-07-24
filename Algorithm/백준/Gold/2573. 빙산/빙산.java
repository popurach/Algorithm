import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N, M, time = 0;
    static boolean flag;
    static boolean[][] isChecked;
    static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] != 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());
    }
    static int bfs() {
        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            Stack<int[]> stack = new Stack<>();
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                int cnt = 0;

                for (int d = 0; d < dir.length; d++) {
                    int ni = cur[0] + dir[d][0];
                    int nj = cur[1] + dir[d][1];

                    if(ni < 0 || nj < 0 || ni > N - 1 || nj > M - 1 || graph[ni][nj] != 0) {
                        continue;
                    }
                    cnt++;
                }
                if(graph[cur[0]][cur[1]] <= cnt) {
                    stack.push(new int[]{cur[0], cur[1]});
                } else {
                    graph[cur[0]][cur[1]] -= cnt;
                    q.offer(new int[] {cur[0], cur[1]});
                }
            }
            while(!stack.isEmpty()) {
                int[] cur = stack.pop();
                graph[cur[0]][cur[1]] = 0;
            }

            isChecked = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(graph[i][j] != 0 && !isChecked[i][j]) {
                        cnt++;
                        isChecked[i][j] = true;
                        dfs(new int[]{i, j});
                    }
                }
            }
            if(cnt >= 2) {
                return time;
            }
        }
        return 0;
    }
    /**
     * @param cur 현재 위치
     *
     * 같은 덩어리인지 체크하는 함수
     * */
    static void dfs(int[] cur) {
        for (int i = 0; i < dir.length; i++) {
            int ni = cur[0] + dir[i][0];
            int nj = cur[1] + dir[i][1];

            if(ni < 0 || nj < 0 || ni > N - 1 || nj > M - 1 || isChecked[ni][nj] || graph[ni][nj] == 0) {
                continue;
            }
            isChecked[ni][nj] = true;
            dfs(new int[]{ni, nj});
        }
    }
}