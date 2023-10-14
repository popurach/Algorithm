import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static boolean flag;
    static StringBuilder sb;
    static Set<Integer> set;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()); //부모
                int B = Integer.parseInt(st.nextToken()); //자식

                list[B].add(A);
            }

            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            flag = false;
            set = new HashSet<>();

            set.add(s1);
            dfs(s1);

            if(set.contains(s2)) {
                sb.append(s2 + "\n");
            } else {
                set.add(s2);
                dfs(s2);
            }
        }
        System.out.println(sb);
    }
    static void dfs(int cur) {
        if(list[cur].size() == 0 || flag) {
            return;
        }
        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            if(set.contains(next)) {
                flag = true;
                sb.append(next + "\n");
                return;
            }
            set.add(next);
            dfs(next);
        }
    }
}