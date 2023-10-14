import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, real, cnt = 0;
    static List<int[]> list;
    static int[] realPerson, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        real = Integer.parseInt(st.nextToken());
        if(real != 0) {
            realPerson = new int[real];
            for (int i = 0; i < real; i++) {
                realPerson[i] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] temp = new int[size];

            int prev = Integer.parseInt(st.nextToken());
            temp[0] = prev;
            for (int j = 1; j < size; j++) {
                int next = Integer.parseInt(st.nextToken());
                temp[j] = next;
                union(prev, next);
            }
            list.add(temp);
        }
        for (int i = 0; i < M; i++) {
            boolean flag = true;
            int[] cur = list.get(i);
            for (int j = 0; j < real; j++) {
                if(isSameParent(realPerson[j], cur[0])) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        }
        return false;
    }
}