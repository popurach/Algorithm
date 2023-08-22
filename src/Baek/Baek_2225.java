package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 중복조합
 * 파스칼의 삼각형
 * */
public class Baek_2225 {
    static int N, K;
    static long[][] pascal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 0~N개의 정수 K개를 더해서 N을 만드는 경우의 수 -> 중복 조합
        // a0 + a1 + ... + aK = N
        // K - 1 개의 울타리를 만든다 !
        // N + K - 1 C K - 1
        pascal = new long[N + K + 1][K + 1];
        pascal[1][1] = 1;
        for (int i = 2; i <= N + K; i++) {
            for (int j = 1; j <= i && j <= K; j++) {
                pascal[i][j] = (pascal[i-1][j-1] + pascal[i-1][j]) % 1000000000;
            }
        }
        System.out.println(pascal[N + K][K]);
    }
}
