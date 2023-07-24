import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

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
        for (int i = 0; i < Math.pow(2, N); i++) {
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