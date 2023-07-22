import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt = 0, removeNode;
    static List<Integer>[] graph;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int rootNode = -1;

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        isVisited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                rootNode = i;
            } else {
                graph[parent].add(i);
            }
        }
        removeNode = Integer.parseInt(br.readLine());
        if(removeNode == rootNode) {
            System.out.println(0);
        } else {
            isVisited[rootNode] = true;
            dfs(rootNode);
            System.out.println(cnt);
        }
    }
    static void dfs(int cur) {
        int count = 0;
        for (int i = 0; i < graph[cur].size(); i++) {
            int nextNode = graph[cur].get(i);
            if(!isVisited[nextNode] && nextNode != removeNode) {
                isVisited[nextNode] = true;
                dfs(nextNode);
                count++;
            }
        }
        if(count == 0) {
            cnt++;
        }
    }
}