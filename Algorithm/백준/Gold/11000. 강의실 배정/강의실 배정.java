import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class lecture implements Comparable<lecture>{
        int S, T;

        public lecture(int s, int t) {
            S = s;
            T = t;
        }

        @Override
        public int compareTo(lecture o) {
            return this.T - o.T;
        }
    }
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<lecture> pq = new PriorityQueue<>();
        StringTokenizer st;
        List<lecture> list = new ArrayList<>();
        int num = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new lecture(start, end));
        }

        Collections.sort(list, (a, b) -> {
            if(a.S == b.S) {
                return a.T - b.T;
            }
            return a.S - b.S;
        });

        pq.offer(new lecture(list.get(0).S, list.get(0).T));
        for (int i = 1; i < N; i++) {
            lecture next = list.get(i);
            lecture cur = pq.poll();
            if(cur.T <= next.S) {
                pq.offer(new lecture(cur.S, next.T));
            } else {
                num ++;
                pq.offer(new lecture(cur.S, cur.T));
                pq.offer(new lecture(next.S, next.T));
            }
        }
        System.out.println(num);
    }

}