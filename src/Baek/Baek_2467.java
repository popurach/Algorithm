package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 용액
 * 산성 용액 1~10억
 * 알칼리 용액 -1~-10억
 * 두 용액을 혼합한 용액의 특성값이 최소인 경우
 *
 * 용액 하나 선택 (idx = i) -> 이분 탐색 사용 (idx + 1, N-1) 범위까지
 * */
public class Baek_2467 {
    static int N, min;
    static int[] answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        answer = new int[2];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            binarySearch(arr[i], i);
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
    static void binarySearch(int num, int idx) {
        int lo = idx + 1, hi = N-1;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if(min > Math.abs(num + arr[mid])) {
                min = Math.abs(num + arr[mid]);
                answer[0] = num;
                answer[1] = arr[mid];
            }
            if(num + arr[mid] < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
    }
}
