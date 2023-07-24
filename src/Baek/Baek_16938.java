package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 비트 마스크를 사용한 조합
 * */
public class Baek_16938 {

    static int N, L, R, X; // N: 문제수, L <= 난이도 <= R, h - l >= X
    static int[] arr, numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < (1 << N); i++) {
//            int len = 0;
//            int max = Integer.MIN_VALUE;
//            int min = Integer.MAX_VALUE;
//            int sum = 0;
//
//            for (int j = 0; j < N; j++) {
//                if ((i & (1 << j)) != 0) { // j번째 배열 값이 조합에 포함됐다면
//                    len++;
//                    max = Math.max(arr[j], max);
//                    min = Math.min(arr[j], min);
//                    sum += arr[j];
//                }
//            }
//
//            if (len == 1) { // 문제는 두 문제 이상이어야 한다
//                continue;
//            }
//            if (sum < L || sum > R) { // 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다
//                continue;
//            }
//            if (max - min < X) { // 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다
//                continue;
//            }
//
//            ans++;

            if(Integer.bitCount(i) >= 2) {
                int temp = i, idx = 0, sum = 0, max = 0, min = Integer.MAX_VALUE;
                while(temp > 0) {
                    if(sum > R) {
                        break;
                    }
                    if((temp & 1) != 0) {
                        sum += arr[idx];
                        if(arr[idx] > max) {
                            max = arr[idx];
                        }
                        if(arr[idx] < min) {
                            min = arr[idx];
                        }
                    }
                    idx++;
                    temp = temp >>> 1;
                }
                if(sum >= L && sum <= R && max - min >= X) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}



//    static void perm(int cnt) {
//        if(cnt == N) {
//            System.out.println(Arrays.toString(numbers));
//            return;
//        }
//        for (int i = 0; i < N; i++) {
//            if(isVisited[i]) continue;
//            isVisited[i] = true;
//            numbers[cnt] = arr[i];
//            perm(cnt + 1);
//            isVisited[i] = false;
//        }
//    }