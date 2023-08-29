import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, lo = 0, hi = 1, height = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hi = Math.max(hi, arr[i]);
        }
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }
            if(sum >= M) {
                height = Math.max(height, mid);
                lo  = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(height);
    }
}