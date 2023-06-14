import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[] people;
    static List<Integer>[] graph;
    static boolean[] isVisited, numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        graph = new ArrayList[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int s = 0; s < size; s++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i <= N / 2; i++) {
            numbers = new boolean[N + 1];
            comb(0, 1, i);
        }
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
    static void comb(int cnt, int start, int num) {
        if(cnt == num) {
            isVisited = new boolean[N + 1];
            check();
            return;
        }
        for (int i = start; i <= N; i++) {
            numbers[i] = true;
            comb(cnt + 1, i + 1, num);
            numbers[i] = false;
        }
    }
    static void check() {
        for (int i = 1; i <= N; i++) {
            if(numbers[i]) {
                isVisited[i] = true;
                dfs(i, true);
                break;
            }
        }
        for (int i = 1; i <= N; i++) {
            if(!numbers[i]) {
                isVisited[i] = true;
                dfs(i, false);
                break;
            }
        }
        int A = 0, B = 0;
        for (int i = 1; i <= N; i++) {
            if(!isVisited[i]) {
                return;
            }
            if(numbers[i]) {
                A += people[i];
            } else {
                B += people[i];
            }
        }
        min = Math.min(min, Math.abs(A - B));
    }
    static void dfs(int cur, boolean flag) {
        for (int i = 0; i < graph[cur].size(); i++) {
            int temp = graph[cur].get(i);
            if(numbers[temp] == flag && !isVisited[temp]) {
                isVisited[temp] = true;
                dfs(temp, flag);
            }
        }
    }
}