import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class beer implements Comparable<beer>{
        int v, c; // v : 선호도, c : 도수 레벨

        public beer(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(beer o) {
            if(this.c == o.c) {
                return this.v - o.v;
            }
            return this.c - o.c;
        }

    }
    static int N, M, K; // N : 축제가 열리는 기간, M : 선호도의 합, K : 맥주 종류의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<beer> pq = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int lowLevel = -1, sumPrefer = 0;
        PriorityQueue<Integer> pqPrefer = new PriorityQueue<>();
        while(!pq.isEmpty()) {
            beer cur = pq.poll();
            pqPrefer.offer(cur.v);
            sumPrefer += cur.v;
            if(pqPrefer.size() > N) {
                sumPrefer -= pqPrefer.poll();
            }
            if(pqPrefer.size() == N && sumPrefer >= M) {
                System.out.println(cur.c);
                System.exit(0);
            }
        }
        System.out.println(lowLevel);
    }
}