package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * IOIOI 문자열
 *
 * IOI 있다면 idx += 2, curCount++
 * IOI 없다면 idx += 1, totalCount += curCount - N + 1, curCount 초기화
 * */
public class Baek_5525re {
    static int N, S;
    static String M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = Integer.parseInt(br.readLine());
        M = br.readLine();

        int idx = 0, curCount = 0, totalCnt = 0;
        while(idx + 2 < S) {
            if(M.substring(idx, idx + 3).equals("IOI")) {
                curCount++;
                idx += 2;
            } else {
                if(curCount >= N) {
                    totalCnt += curCount - N + 1;
                }
                curCount = 0;
                idx += 1;
            }
        }
        if(curCount >= N) {
            totalCnt += curCount - N + 1;
        }
        System.out.println(totalCnt);
    }
}
