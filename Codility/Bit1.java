package Codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 이진수로 나타냈을 때, 부호 비트 1과 1 사이의 0의 최대개수 구하기
 * 반복문에서 1과 N의 합집합이 1인지 확인 
 * N = N >> 1 처리 후 다음 루프 진행
 * */
public class Bit1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }
    static int solution(int N) {
        int max = 0, index = 0, left = -1, right = -1;
        while(N > 0) {
            if((N & 1) != 0) {
                if(left == -1) {
                    left = index;
                } else {
                    right = left;
                    left = index;
                    max = Math.max(max, left - right - 1);
                }
            }
            index++;
            N = N>>>1;
        }
        return max;
    }
}
