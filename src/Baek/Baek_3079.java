package Baek;
// 미완성 !!!!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_3079 {
    static class node implements Comparable<node>{
        int originTime;
        long totalTime;
        boolean isChecked;

        public node(int originTime, long totalTime, boolean isChecked) {
            this.originTime = originTime;
            this.totalTime = totalTime;
            this.isChecked = isChecked;
        }

        @Override
        public int compareTo(node o) {
            return (int) ((this.totalTime + this.originTime) - (o.totalTime + o.originTime));
        }

    }
    static int N, M;
    static int[] T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<node> pq = new PriorityQueue<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            pq.offer(new node(temp, 0, false));
        }
        long max = 0;
        for (int i = 0; i < M; i++) {
            node cur = pq.poll();
            pq.offer(new node(cur.originTime, cur.totalTime + cur.originTime, true));
            max = Math.max(max, cur.totalTime + cur.originTime);
        }
        System.out.println(max);
    }
}
