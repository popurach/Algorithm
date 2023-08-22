package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 가장 긴 바이토닉 부분 수열
 * dp -> 본인보다 작은 수 있다면 dp[i] = Math.max(dp[i], dp[j] + 1)
 * */
public class Baek_11054 {
    static int N;
    static int[] arr, dpAsc, dpDesc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N + 1];
        dpAsc = new int[N + 1];
        dpDesc = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dpAsc[i] = Math.max(dpAsc[j] + 1, dpAsc[i]);
                }
            }
        }

        for (int i = N; i >= 1; i--) {
            for (int j = N; j > i; j--) {
                if(arr[j] < arr[i]) {
                    dpDesc[i] = Math.max(dpDesc[j] + 1, dpDesc[i]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dpAsc[i] + dpDesc[i]);
        }
        System.out.println(max + 1);
    }
}
