import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N, max = 0;
    static long maxLength = 1;
    static int[] lan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan = new int[K];

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }
        if(N != 1) {
            binarySearch();
        } else {
            System.out.println(max);
        }
    }
    static void binarySearch() {
        long lo = 1, hi = max;

        while(lo <= hi) {
            long mid = (lo + hi)/2;
            long num = 0;
            for (int i = 0; i < K; i++) {
                if(lan[i] >= mid) {
                    num += lan[i] / mid;
                }
            }
            if(num >= N) {
                maxLength = Math.max(maxLength, mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(maxLength);
    }
}