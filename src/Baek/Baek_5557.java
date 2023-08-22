package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1학년
 * N개의 숫자가 주어지고 숫자 사이에 '+' 또는 '-'를 넣어 등식을 만듦
 * 중간에 나오는 수 모두 0이상 20이하
 * dp -> arr[N-1][21]을 선언하여 O(N-1 x 21)으로 풀이 가능
 * */
public class Baek_5557 {
    static int N;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N-1][21];
        numbers = new int[N-1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N-1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.parseInt(st.nextToken());

        arr[0][numbers[0]] = 1;

        for (int i = 1; i < N-1; i++) {
            for (int j = 0; j <= 20; j++) {
                if(arr[i-1][j] != 0) {
                    if(j + numbers[i] >= 0 && j + numbers[i] <= 20) {
                        arr[i][j + numbers[i]] += arr[i-1][j];
                    }
                    if(j - numbers[i] >= 0 && j - numbers[i] <= 20) {
                        arr[i][j - numbers[i]] += arr[i-1][j];
                    }
                }
            }
        }
        System.out.println(arr[N-2][answer]);
    }
}
