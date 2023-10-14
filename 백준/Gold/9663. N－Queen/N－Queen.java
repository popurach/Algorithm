import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt = 0;
    static boolean[] isChecked;
    static int[] nqueen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nqueen = new int[N + 1];
        dfs(1);
        System.out.println(cnt);
    }
    static void dfs(int depth) {
        if(depth == N + 1) {
            cnt += 1;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(check(depth, i)) {
                nqueen[depth] = i;
                dfs(depth + 1);
            }
        }
    }
    static boolean check(int depth, int idx) {
        // 세로, 대각선 방향
        for (int i = 1; i < depth; i++) {
            if(nqueen[i] == idx) {
                return false;
            }
            if(nqueen[i] + (depth - i) == idx || nqueen[i] - (depth - i) == idx) {
                return false;
            }
        }
        return true;
    }
}