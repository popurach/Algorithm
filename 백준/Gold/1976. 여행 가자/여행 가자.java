import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 도시의 수, 여행 계획에 속한 도시들의 수
    static List<Integer>[] graph;
    static int[] plans;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        plans = new int[M];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(i > j && temp == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M - 1; i++) {
            if(!bfs(plans[i], plans[i + 1])) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
    static boolean bfs(int cur, int target) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];
        q.offer(cur);
        isVisited[cur] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            if(current == target) {
                return true;
            }
            for (int i = 0; i < graph[current].size(); i++) {
                int next = graph[current].get(i);
                if(isVisited[next]) continue;
                q.offer(next);
                isVisited[next] = true;
            }
        }
        return false;
    }
}