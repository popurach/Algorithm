import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static class node {
        int cnt, idx;

        public node(int cnt, int idx) {
            this.cnt = cnt;
            this.idx = idx;
        }

    }
    static int N, M;
    static Map<Integer, Integer> map;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(u, v);
        }

        bfs();
    }
    static void bfs() {
        PriorityQueue<node> pq = new PriorityQueue<>((x, y) -> {
            if(x.cnt == y.cnt) {
                return y.idx - x.idx;
            }
            return x.cnt - y.cnt;
        });

        pq.offer(new node(0, 1));
        set.add(1);
        while (!pq.isEmpty()) {
            node cur = pq.poll();
            if(cur.idx == 100) {
                System.out.println(cur.cnt);
                System.exit(0);
            }

            for (int i = 1; i <= 6; i++) {
                int nextIdx = cur.idx + i;
                if(nextIdx > 100) {
                    break;
                }
                if(set.contains(nextIdx)) {
                    continue;
                }
                set.add(nextIdx);
                if(map.containsKey(nextIdx)) {
                    nextIdx = map.get(nextIdx);
                    set.add(nextIdx);
                }
                pq.offer(new node(cur.cnt + 1, nextIdx));
            }
        }
    }
}