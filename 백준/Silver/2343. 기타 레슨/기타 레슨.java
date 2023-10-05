import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int max = 0, min = 0, result = 10000;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
            min = Integer.max(min, arr[i]);
        }

        int lo = min, hi = max;
        while(lo <= hi) {
            int mid = (lo + hi)/2;

            int cnt = 0, sum = 0;
            for (int i = 0; i < N; i++) {
                if(sum + arr[i] < mid) {
                    sum += arr[i];
                } else if(sum + arr[i] == mid) {
                    cnt += 1;
                    sum = 0;
                } else {
                    cnt += 1;
                    sum = arr[i];
                }
            }
            if(sum != 0) {
                cnt += 1;
            }

            if(cnt > M) {
                lo = mid + 1;
            } else {
                result = mid;
                hi = mid - 1;
            }
        }
        System.out.println(result);
    }
}