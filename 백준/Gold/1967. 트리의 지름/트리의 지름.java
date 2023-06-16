import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class node {
        int V, cost;

        public node(int v, int cost) {
            this.V = v;
            this.cost = cost;
        }

    }
    static int n, max = 0;
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
        for (int i = 1; i <= n; i++) {
            isVisited[i] = true;
            for (int j = 0; j < graph[i].size(); j++) {
                node cur = graph[i].get(j);
                isVisited[cur.V] = true;
                dfs(cur.V, cur.cost);
                isVisited[cur.V] = false;
            }
            isVisited[i] = false;
        }
        System.out.println(max);
    }
    static void dfs(int cur, int sum) {
        if(sum > max) {
            max = sum;
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