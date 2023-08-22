package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2138 {
    static int N, min = Integer.MAX_VALUE;
    static int[] arr, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = new int[N];

        int[] arr1 = new int[N]; // 0번을 킨 경우
        int[] arr2 = new int[N]; // 0번을 안 킨 경우
        int cnt1 = 0;
        int cnt2 = 0;

        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i) - '0';
            arr1[i] = arr2[i] = arr[i];
        }
        str = br.readLine();
        for (int i = 0; i < N; i++) {
            answer[i] = str.charAt(i) - '0';
        }

        arr1[0] = 1 - arr1[0];
        arr1[1] = 1 - arr1[1];
        cnt1 += 1;

        for (int i = 1; i < N; i++) {
            // 0번째 전구를 킨 경우
            if(arr1[i-1] != answer[i-1]) {
                arr1[i-1] = 1 - arr[i-1];
                arr1[i] = 1 - arr1[i];
                cnt1 += 1;
                if(i != N-1) {
                    arr1[i + 1] = 1 - arr1[i + 1];
                }
            }

            // 0 번째 전구를 키지 않은 경우
            if(arr2[i-1] != answer[i-1]) {
                arr2[i-1] = 1 - arr2[i-1];
                arr2[i] = 1 - arr2[i];
                cnt2 += 1;
                if(i != N-1) {
                    arr2[i + 1] = 1 - arr2[i + 1];
                }
            }
        }
        if(arr1[N-1] == answer[N-1]) {
            min = Math.min(min, cnt1);
        }
        if(arr2[N-1] == answer[N-1]) {
            min = Math.min(min, cnt2);
        }
        System.out.println(min == Integer.MAX_VALUE? -1: min);
    }
}
