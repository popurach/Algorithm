import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt = 0, start = -1; // 점의 개수, 진행된 차례의 수
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if(isSameParent(a, b)) {
                System.out.println(i + 1);
                System.exit(0);
            }
            union(a, b);
        }
        System.out.println(0);
    }
    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
    static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if(x==y) {
            return true;
        }
        return false;
    }
}