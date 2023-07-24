package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 약수의 합
 *
 * 누적합 개념 + 에라토스테네스의 체-O(NlogN)
 * */
public class Baek_17425 {
    static int T, N;
    static long[] f, g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        f = new long[1000001];
        Arrays.fill(f, 1);
        g = new long[1000001];

        for (int i = 2; i <= 1000000; i++) {
            for (int j = 1; i * j <= 1000000; j++) {
                f[i * j] += i;
            }
        }
        for (int i = 1; i <= 1000000; i++) {
            g[i] += g[i - 1] + f[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            sb.append(g[N] + "\n");
        }
        System.out.println(sb);
    }
}
