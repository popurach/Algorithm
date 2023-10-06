import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dfs(0);
        System.out.println(cnt);
    }
    static void dfs(int depth) {
        if(depth == N) {
            cnt += 1;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if(possible(depth)) {
                dfs(depth + 1);
            }
        }
    }
    static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            // 이전 행에 같은 값이 있는지 확인
            if(arr[i] == arr[col]) {
                return false;
            }
            // 대각선 확인
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}