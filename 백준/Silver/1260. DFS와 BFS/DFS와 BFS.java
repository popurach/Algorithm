import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static StringBuilder sb;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            list[i].sort((a, b) -> a - b);
        }
        dfs(V, new boolean[N + 1]);
        sb.append("\n");
        bfs();
        System.out.println(sb);
    }
    static void dfs(int cur, boolean[] isVisited) {
        if(isVisited[cur]) {
            return;
        }
        sb.append(cur + " ");
        isVisited[cur] = true;
        List<Integer> next = list[cur];
        next.sort((a, b) -> a - b);

        for (int i = 0; i < next.size(); i++) {
            if(!isVisited[next.get(i)]) {
                dfs(next.get(i), isVisited);
            }
        }
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] isVisited = new boolean[N + 1];
        isVisited[V] = true;
        q.add(V);
        sb.append(V + " ");
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                int temp = list[cur].get(i);
                if(isVisited[temp]) {
                    continue;
                }
                isVisited[temp] = true;
                q.add(temp);
                sb.append(temp + " ");
            }
        }
    }
//    static void bfs() {
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
//        boolean[] isVisited = new boolean[N + 1];
//
//        pq.offer(V);
//        isVisited[V] = true;
//
//        Stack<Integer> stack;
//
//        while(!pq.isEmpty()) {
//            int cnt = pq.size();
//            stack = new Stack<>();
//
//            for (int i = 0; i < cnt; i++) {
//                int cur = pq.poll();
//                sb.append(cur + " ");
//
//                for (int j = 0; j < list[cur].size(); j++) {
//                    if(!isVisited[list[cur].get(j)]) {
//                        stack.push(list[cur].get(j));
//                        isVisited[list[cur].get(j)] = true;
//                    }
//                }
//            }
//            while(!stack.isEmpty()) {
//                pq.offer(stack.pop());
//            }
//        }
//    }
}