package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 슬라이드 윈도우
 * */
public class Baek_21921 {
    static int N, X, cnt = 0, max = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i>=1 && i<=X) {
                sum += arr[i];
            }
        }
        int left = 1, high = X;

        for (int i = 1; i <= N - X + 1; i++) {
            if(sum > max) {
                max = sum;
                cnt = 1;
            } else if(sum == max) {
                cnt += 1;
            }
            if(i + X > N) {
                break;
            }
            sum = sum - arr[i] + arr[i + X];
        }
//        while(true) {
//            if(sum > max) {
//                max = sum;
//                cnt = 1;
//            } else if(sum == max) {
//                cnt++;
//            }
//            sum -= arr[left];
//            left += 1;
//            high += 1;
//            if(high > N) {
//                break;
//            }
//            sum += arr[high];
//        }
        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
