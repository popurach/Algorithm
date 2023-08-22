package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 나무 자르기
 * 나무 M미터가 필요하다. 특정 높이를 절단기로 자를 때
 * 적어도 M미터의 나무를 집에 가져가기 위해 설정할 높이의 최댓값
 *
 * 이분탐색 -> lo:0 hi:maxHeight
 * mid로 잘랐을 때 나오는 나무의 값 M 비교
 * */
public class Baek_2805 {
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
//            System.out.println("mid : " + mid + " sum : " + sum);
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
