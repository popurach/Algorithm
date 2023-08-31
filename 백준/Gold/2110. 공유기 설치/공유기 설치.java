import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자 카드, 랜선 자르기, 나무 자르기 순서대로 풀어보자!
 */
public class Main {

    static int N, C, maxLength = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        binarySearch();
    }
    static void binarySearch() {
        int lo = 1, hi = arr[N-1] - arr[0];

        while(lo <= hi) {
            int mid = (hi + lo) / 2;
            int idx = 0, cnt = 1;
            for (int i = 1; i < N; i++) {
                if(arr[i] >= arr[idx] + mid) {
                    cnt += 1;
                    idx = i;
                }
            }
            if(cnt >= C) {
                maxLength = Math.max(maxLength, mid);
                lo = mid + 1;
            } else {
                hi  = mid - 1;
            }
        }
        System.out.println(maxLength);
    }
}