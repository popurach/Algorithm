import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K, sum = 0;
    static PriorityQueue<Integer> pq;
    static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int j2 = Integer.parseInt(st.nextToken());

            list.add(new int[]{M - 1 - j1, i1, Math.abs(M - j2), i2 - 1});
        }

        for (int i = 0; i < K; i++) {
            int[] temp = list.get(i);
            drawGraph(new int[]{temp[0], temp[1]}, new int[]{temp[2], temp[3]});
        }

        int cnt = 0;
        pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 0) {
                    cnt += 1;
                    sum = 0;
                    dfs(new int[]{i, j});
                    pq.offer(sum);
                }
            }
        }
        System.out.println(cnt);
        while(!pq.isEmpty()) {
            sb.append(pq.poll() + " ");
        }
        System.out.println(sb);
    }
    static void drawGraph(int[] start, int[] end) {
        for (int i = end[0]; i <= start[0]; i++) {
            for (int j = start[1]; j <= end[1]; j++) {
                if(graph[i][j] == 0) {
                    graph[i][j] = 1;
                }
            }
        }
    }
    static void dfs(int[] cur) {
        // 방문 처리
        graph[cur[0]][cur[1]] = 1;
        sum += 1;
        for (int i = 0; i < dir.length; i++) {
            int ni = cur[0] + dir[i][0];
            int nj = cur[1] + dir[i][1];

            if(ni < 0 || nj < 0 || ni >= M || nj >= N || graph[ni][nj] == 1) {
                continue;
            }
            dfs(new int[]{ni, nj});
        }
    }
}