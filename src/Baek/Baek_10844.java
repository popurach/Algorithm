package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 쉬운 계단 수
 * 인접한 모든 자리의 수의 차이가 1 = 계단 수
 * 45656 등
 * 0으로 시작하는 수는 계단수가 아님
 * [0, 1, 1, 1, 1, 1, 1, 1, 1, 1] 로 시작하고
 * 0, 9 인덱스는 따로 처리, 외 인덱스는 next[j-1] += cur[j] next[j+1] += cur[j]
 * */
public class Baek_10844 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] cur = new long[10];
        long[] next = new long[10];
        long sum = 0;
        Arrays.fill(cur, 1);
        cur[0] = 0;

        for (int i = 1; i <= N; i++) {
            Arrays.fill(next, 0);
            for (int j = 0; j < 10; j++) {
                if(cur[j] != 0) {
                    if(j - 1 >=0) {
                        next[j-1] += cur[j];
                        next[j-1] %= 1000000000;
                    }
                    if(j + 1 <= 9) {
                        next[j+1] += cur[j];
                        next[j+1] %= 1000000000;
                    }
                }
            }
            if(i == N) {
                for (int j = 0; j < 10; j++) {
                    sum += cur[j];
                    sum %= 1000000000;
                }
                break;
            }
            for (int j = 0; j < 10; j++) {
                cur[j] = next[j];
            }
        }
        System.out.println(sum);
    }
}
