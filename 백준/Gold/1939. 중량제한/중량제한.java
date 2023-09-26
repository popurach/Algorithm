import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class node {
        int idx, cost;

        public node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

    }
    static int N, M, result = 1, s, e, min = Integer.MAX_VALUE, max = 1; // 섬의 개수, 다리의 개수
    static boolean[] isVisited;
    static Queue<Integer> q;
    static List<node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            max = Math.max(max, C);
            min = Math.min(min, C);
            list[A].add(new node(B, C));
            list[B].add(new node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        
        while(max >= min) {
            int mid = (max + min)/2;
            
            q.clear();
            if(bfs(mid)) {
                result = Integer.max(result, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(result);
    }
    static boolean bfs(int mid) {
        isVisited = new boolean[N + 1];

        q.offer(s);
        isVisited[s] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == e) {
                return true;
            }
            for (int i = 0; i < list[cur].size(); i++) {
                node next = list[cur].get(i);
                if(isVisited[next.idx] || next.cost < mid) {
                    continue;
                }
                q.offer(next.idx);
                isVisited[next.idx] = true;
            }
        }
        return false;
    }
}