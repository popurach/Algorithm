package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * IOIOI 문자열
 * */
public class Baek_5525 {
    static int N, S;
    static String P = "", M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = Integer.parseInt(br.readLine());
        M = br.readLine();

        makeP();
        int cnt = 0;
        for (int i = 0; i <= M.length() - P.length(); i++) {
            if(M.substring(i, i + P.length()).equals(P)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void makeP() {
        for (int i = 0; i < 2*N + 1; i++) {
            if(i % 2 == 0) {
                P += "I";
            } else {
                P += "O";
            }
        }
    }
}
