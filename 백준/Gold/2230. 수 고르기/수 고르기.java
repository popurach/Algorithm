import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Integer[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new Integer[N];
        for (int i = 0; i <= N - 1; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A, (a, b) -> a - b);
        int lo = 0, hi = 0;
        int min = Integer.MAX_VALUE;
        while(lo <= hi) {
            if(A[hi] - A[lo] >= M) {
                min = Math.min(min, A[hi] - A[lo]);
                lo += 1;
            } else {
                hi += 1;
            }
            if(lo > N -1 || hi > N-1) {
                break;
            }
        }
        System.out.println(min);
    }
}