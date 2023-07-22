package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * N개의 수 중 두 수의 차이가 M 이상중에서 최솟값 구하기
 * 1. 투 포인터
 * 2. 이분 탐색
 *
 * */
public class Baek_2230 {
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

        // 투 포인터 사용법
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
