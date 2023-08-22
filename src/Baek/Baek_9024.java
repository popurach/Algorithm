package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 두 수의 합
 *
 * 두 수의 합이 K와 가장 가까운 조합의 수
 * 이분 탐색, 투 포인터
 * */
public class Baek_9024 {
    static int t, n, K, cnt, closeNum;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            closeNum = arr[0] + arr[n-1];
            cnt = 0;

            binarySearch();
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
    static void binarySearch() {
        int lo = 0, hi = n - 1;

        while(lo < hi) {
            int mid = arr[lo] + arr[hi];

            if(Math.abs(K - closeNum) > Math.abs(K - mid)) {
                closeNum = mid;
                cnt = 1;
            } else if(Math.abs(K - closeNum) == Math.abs(K - mid)) {
                cnt += 1;
            }

            if(mid == K) {
                hi -= 1;
                lo += 1;
            } else if(mid > K) {
                hi -= 1;
            } else {
                lo += 1;
            }
        }
    }
}
