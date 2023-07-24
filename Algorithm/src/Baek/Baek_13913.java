package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_13913 {
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
    static int N, K;
    static int[] parent;
    static boolean[] isVisited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        isVisited = new boolean[100001];
        parent = new int[100001];

        bfs();
        System.out.println(sb);
    }
    static void bfs() {
        PriorityQueue<human> pq = new PriorityQueue<>();
        pq.offer(new human(N, 0));
        isVisited[N] = true;

        while(!pq.isEmpty()) {
            human cur = pq.poll();
            if(cur.location == K) {
                sb.append(cur.count + "\n");
                Stack<Integer> stack = new Stack<>();
                int start = K;
                stack.push(start);
                while(start != N) {
                    start = parent[start];
                    stack.push(start);
                }
                while(!stack.isEmpty()) {
                    sb.append(stack.pop() + " ");
                }
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
}
