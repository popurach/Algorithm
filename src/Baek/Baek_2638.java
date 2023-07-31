package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 치즈 (그래프 + 시뮬레이션 + bfs)
 * N×M 치즈 격자에 4변 중 적어도 2변 이상이 외부 공기와 접촉하면 녹음
 * 내부 공기는 안녹음
 *
 * 가장자리에는 치즈가 없으므로 (0, 0)을 이용해서 매 번 외부 공기 계산
 * */
public class Baek_2638 {
    static int N, M, cnt = 0, count;
    static int[][] graph, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] isChecked;
    static Deque<int[]> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        isChecked = new boolean[N][M];
        Stack<int[]> stack = new Stack<>(); // 한번에 삭제용 스택
        dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    dq.offer(new int[]{i, j});
                }
            }
        }

        while(!dq.isEmpty()) {
            bfs();
            int size = dq.size();

            for (int i = 0; i < size; i++) {
                int[] cur = dq.poll();
                count = 0;

                // 4방향 확인
                for (int j = 0; j < 4; j++) {
                    int ni = cur[0] + dir[j][0];
                    int nj = cur[1] + dir[j][1];

                    if(isChecked[ni][nj]) {
                        count++;
                    }
                    if(count>=2) {
                        break;
                    }
                }
                if(count >= 2) {
                    stack.push(new int[]{cur[0], cur[1]});
                } else {
                    dq.offerLast(new int[]{cur[0], cur[1]});
                }
            }
            cnt++;
            while(!stack.isEmpty()) {
                int[] temp = stack.pop();
                graph[temp[0]][temp[1]] = 0;
            }
        }
        System.out.println(cnt);
    }
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        isChecked = new boolean[N][M];
        q.offer(new int[]{0, 0});
        isChecked[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int j = 0; j < dir.length; j++) {
                int ni = cur[0] + dir[j][0];
                int nj = cur[1] + dir[j][1];

                if(ni<0 || nj<0 || ni>N-1 || nj>M-1 || isChecked[ni][nj] || graph[ni][nj] != 0) {
                    continue;
                }
                q.offer(new int[]{ni, nj});
                isChecked[ni][nj] = true;
            }
        }
    }
}
