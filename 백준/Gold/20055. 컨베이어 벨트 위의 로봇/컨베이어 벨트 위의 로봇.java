import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, count = 0;
    static int[] graph;
    static boolean[] isVisited;
    static Queue<Integer> q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[2 * N + 1];
        q = new LinkedList<>();
        isVisited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        while(countBelt() < K) {
            rotate();
            move();
            if(graph[1] > 0) {
                q.offer(1);
                isVisited[1] = true;
                graph[1] -= 1;
            }
            count ++;
        }
        System.out.println(count);
    }
    static int countBelt() {
        int cnt = 0;

        for (int i = 1; i <= 2*N; i++) {
            if(graph[i] == 0) {
                cnt ++;
            }
        }
        return cnt;
    }

    // 컨베이어 벨트 회전
    static void rotate() {
        int temp = graph[2 * N];
        for (int i = 2 * N; i > 1 ; i--) {
            graph[i] = graph[i - 1];
        }
        graph[1] = temp;

        Arrays.fill(isVisited, false);
        int size = q.size();
        for (int s = 0; s < size; s++) {
            int cur = q.poll();
            cur += 1;
            if(cur < N) {
                q.offer(cur);
                isVisited[cur] = true;
            }
        }
    }
    static void move() {
        int size = q.size();
        for (int s = 0; s < size; s++) {
            int cur = q.poll();
            if(graph[cur + 1] >= 1 && !isVisited[cur + 1]) {
                isVisited[cur] = false;

                q.offer(cur + 1);
                isVisited[cur + 1] = true;

                graph[cur + 1] -= 1;
            } else {
                q.offer(cur);
            }
        }
    }
}