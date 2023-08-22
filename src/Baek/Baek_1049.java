package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 기타줄
 * 그리디 알고리즘
 * */
public class Baek_1049 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int setMin = 1000, singleMin = 1000;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            setMin = Math.min(setMin, Integer.parseInt(st.nextToken()));
            singleMin = Math.min(singleMin, Integer.parseInt(st.nextToken()));
        }
        System.out.println(Math.min((N/6) * setMin + (N%6) * singleMin,
                                    Math.min((N/6 + 1) * setMin, N * singleMin)));
    }
}
