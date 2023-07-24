package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 1. Deque
 * 벽을 부수지 않았으면 offerFirst() , 벽을 부쉈으면 offer()
 * 2. 우선순위큐
 *
 * */
public class Baek_2665 {
    static class move implements Comparable<move>{
        int y, x, count;
        public move(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        @Override
        public int compareTo(move o) {
            return this.count - o.count;
        }

    }
    static int n;
    static int[][] graph, D, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        D = new int[n][n]; // 현재 위치까지 최소로 벽을 부순 개수를 저장

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            Arrays.fill(D[i], n*n);
            for (int j = 0; j < n; j++) {
                graph[i][j] = temp.charAt(j) - '0';
            }
        }
        // 2. 우선 순위 큐를 사용
//        PriorityQueue<move> pq = new PriorityQueue<>();
//        pq.offer(new move(0, 0, 0));
//        D[0][0] = 0;
//        while(!pq.isEmpty()) {
//            move cur = pq.poll();

//             종결 조건

//            if(cur.y == n-1 && cur.x == n-1) {
//                System.out.println(cur.count);
//                System.exit(0);
//            }
//            for (int i = 0; i < dir.length; i++) {
//                int ni = cur.y + dir[i][0];
//                int nj = cur.x + dir[i][1];
//
//                if(ni < 0 || nj < 0 || ni > n-1 || nj > n-1 || D[ni][nj] < cur.count) {
//                    continue;
//                }
//                if(graph[ni][nj] == 1 && D[ni][nj] > cur.count) {
//                    pq.offer(new move(ni, nj, cur.count));
//                    D[ni][nj] = cur.count;
//                } else if(graph[ni][nj] == 0 && D[ni][nj] > cur.count + 1) {
//                    pq.offer(new move(ni, nj, cur.count + 1));
//                    D[ni][nj] = cur.count + 1;
//                }
//            }
//        }
        // 1. 1-0 BFS 사용
        bfs();
    }
    static void bfs() {
        Deque<move> dq = new ArrayDeque<>();
        dq.add(new move(0, 0, 0));
        D[0][0] = 0;

        while(!dq.isEmpty()) {
            move cur = dq.poll();
            if(cur.y == n-1 && cur.x == n-1) {
                System.out.println(cur.count);
                return;
            }
            for (int i = 0; i < dir.length; i++) {
                int ni = cur.y + dir[i][0];
                int nj = cur.x + dir[i][1];

                if(ni <0 || nj<0 || ni>n-1 || nj>n-1 || D[ni][nj] < cur.count + 1) {
                    continue;
                }
                if(graph[ni][nj] == 0) {
                    dq.offer(new move(ni, nj, cur.count + 1));
                    D[ni][nj] = Math.min(D[ni][nj], cur.count + 1);
                } else if(graph[ni][nj] == 1) {
                    dq.offerFirst(new move(ni, nj, cur.count));
                    D[ni][nj] = Math.min(D[ni][nj], cur.count);
                }
            }
        }
    }
}

