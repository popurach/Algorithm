package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 * 오름차순 정렬 후 투 포인터 or 이분탐색
 * 투 포인터 -> 두 수의 합이 0보다 크면 hi -= 1, 0보다 작으면 lo += 1
 * */
public class Baek_2470 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lo = 0, hi = N - 1, min = Integer.MAX_VALUE;
        int sol1 = arr[lo], sol2 = arr[hi];
        while(lo < hi) {
            int sum = arr[lo] + arr[hi];
            if(Math.abs(sum) < min) {
                sol1 = arr[lo];
                sol2 = arr[hi];
                min = Math.abs(sum);
            }
            if(sum > 0) {
                hi -= 1;
            } else {
                lo += 1;
            }
        }
        System.out.println(sol1 + " " + sol2);
    }
}
