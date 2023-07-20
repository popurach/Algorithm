import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 포도주 시식
 * 1부터 n까지의 포도주를 마실 때, 연속으로 놓인 3잔을 모두 마실 수 없음
 * 최대 마실 수 있는 포도주 양
 * dp : Bottom-Up 방식 (반복문 구현)
 * */
public class Main {
    static int n;
    static int[] arr, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        d[1] = arr[1];
        if(n > 1) {
            d[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(d[i-1], Math.max(d[i-2] + arr[i], d[i-3] + arr[i-1] + arr[i]));
        }
        System.out.println(d[n]);
    }
}