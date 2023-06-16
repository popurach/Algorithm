import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Deque -> 우선 순위 높으면 offerFirst로 앞에 넣음
 * dis 거리 배열을 통해 최단거리 비교
 * */
public class Main {
    static int N, K;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dis = new int[100001];
        Arrays.fill(dis, Integer.MAX_VALUE);

        bfs();
        System.out.println(dis[K]);
    }
    static void bfs() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);
        dis[N] = 0;

        while(!dq.isEmpty()) {
            int cur = dq.poll();

            if(cur == K) {
                return;
            }
            if(cur * 2 <= 100000 && dis[cur * 2] == Integer.MAX_VALUE) {
                dq.offerFirst(cur * 2);
                dis[cur * 2] = dis[cur];
            }
            if(cur + 1 <= 100000 && dis[cur + 1] > dis[cur] + 1) {
                dq.offer(cur + 1);
                dis[cur + 1] = dis[cur] + 1;
            }
            if(cur - 1 >= 0 && dis[cur - 1] > dis[cur] + 1) {
                dq.offer(cur - 1);
                dis[cur - 1] = dis[cur] + 1;
            }
        }
    }
}