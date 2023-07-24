import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 1. 루트 노드 (1번 노드)로부터 가장 먼 리프 노드에서 DFS
 * 2. 리프 노드 (간선이 1개인 끝 노드) 집합에서 DFS
 * */
public class Main {
    static class node {
        int V, cost;

        public node(int v, int cost) {
            this.V = v;
            this.cost = cost;
        }

    }
    static int n, max = 0, furtherNode = 1;
    static boolean[] isVisited;
    static List<node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[child].add(new node(parent, cost));
            graph[parent].add(new node(child, cost));
        }

        // 루트노드로부터 가장 멀리있는 리프노드를 구한다
        isVisited[1] = true;
        dfs(1, 0);
        isVisited[1] = false;
        max = 0;

        // 리프노드로부터 가장 멀리있는 노드를 구함
        isVisited[furtherNode] = true;
        dfs(furtherNode, 0);

        System.out.println(max);
    }
    static void dfs(int cur, int sum) {
        if(sum > max) {
            max = sum;
            furtherNode = cur;
        }
        for (int i = 0; i < graph[cur].size(); i++) {
            node next = graph[cur].get(i);
            if(!isVisited[next.V]) {
                isVisited[next.V] = true;
                dfs(next.V, sum + next.cost);
                isVisited[next.V] = false;
            }
        }
    }
}