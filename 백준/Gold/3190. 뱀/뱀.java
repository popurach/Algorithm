import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L, time = 0;
    static int[][] graph, dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // 상, 좌, 하, 우
    static Deque<int[]> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        graph = new int[N + 2][N + 2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1; // 사과
        }
        L = Integer.parseInt(br.readLine());
        dq = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            if(C=='D') {
                dq.offer(new int[]{ X, -1});
            } else if(C=='L') {
                dq.offer(new int[]{ X, 1});
            }
        }
        bfs();
        System.out.println(time + 1);
    }
    static void bfs() {
        int d = 3;
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{1, 1});
        graph[1][1] = -1; // 뱀의 위치

        while(true) {
            if(!dq.isEmpty()) {
                int[] cur = dq.poll();

                if (cur[0] == time) {
                    if(d == 0 && cur[1] == -1) {
                        d = 3;
                    } else {
                        d = (d + cur[1]) % 4;
                    }
                } else {
                    dq.offerFirst(new int[] { cur[0], cur[1] });
                }
            }
            int[] curSnake = snake.pollFirst();
//            System.out.println("현재 뱀 위치 : " + Arrays.toString(curSnake) + " 뱀 길이 : " + length);
            int ni = curSnake[0] + dir[d][0];
            int nj = curSnake[1] + dir[d][1];
            snake.offerFirst(new int[]{curSnake[0], curSnake[1]});
            if(ni < 1 || nj < 1 || ni > N || nj > N || graph[ni][nj] == -1) {
                break;
            } else if(graph[ni][nj] == 0) {
                int[] snakeTail = snake.pollLast();
                graph[snakeTail[0]][snakeTail[1]] = 0;
            }
            graph[ni][nj] = -1;
            snake.offerFirst(new int[]{ni, nj});
            time += 1;
        }
    }
}