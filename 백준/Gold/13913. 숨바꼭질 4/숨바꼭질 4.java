import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class human implements Comparable<human>{
        int location, count;

        public human(int location, int count) {
            this.location = location;
            this.count = count;
        }

        @Override
        public int compareTo(human o) {
            if(this.count == o.count) {
                return Math.abs(this.location - K) - Math.abs(o.location - K);
            }
            return this.count - o.count;
        }
    }
    static int N, K, cnt = 0;
    static int[] parent;
    static List<Integer> list;
    static boolean[] isVisited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        isVisited = new boolean[100001];
        parent = new int[100001];
        sb = new StringBuilder();

        bfs();
        System.out.println(cnt);
        check(K);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
    static void bfs() {
        PriorityQueue<human> pq = new PriorityQueue<>();
        pq.offer(new human(N, 0));
        isVisited[N] = true;

        while(!pq.isEmpty()) {
            human cur = pq.poll();
            if(cur.location == K) {
                cnt = cur.count;
                return;
            }
            if(cur.location - 1 >= 0 && !isVisited[cur.location - 1]) {
                pq.offer(new human(cur.location - 1, cur.count + 1));
                isVisited[cur.location - 1] = true;
                parent[cur.location - 1] = cur.location;
            }
            if(cur.location + 1 <= 100000 && !isVisited[cur.location + 1]) {
                pq.offer(new human(cur.location + 1, cur.count + 1));
                isVisited[cur.location + 1] = true;
                parent[cur.location + 1] = cur.location;
            }
            if(cur.location * 2 <= 100000 && !isVisited[cur.location * 2]) {
                pq.offer(new human(cur.location * 2, cur.count + 1));
                isVisited[cur.location * 2] = true;
                parent[cur.location * 2] = cur.location;
            }
        }
    }
    static void check(int cur) {
        list.add(cur);
        if(cur == N) {
            return;
        }
        check(parent[cur]);
    }
}