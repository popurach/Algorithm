package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/**
 * 1. 일반 풀이
 * 2. 비트 마스킹
 * */
public class Baek_1094 {
    static int X;
//    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
//        if(X == 64) {
//            System.out.println(1);
//            System.exit(0);
//        }
//        int cnt = 0;
//        pq = new PriorityQueue<>();
//        pq.add(64);
//        while(X > 0) {
//            int cur = pq.poll();
//            cur = cur>>1;
//            if(X >= cur) {
//                X -= cur;
//                cnt++;
//            }
//            pq.offer(cur);
//        }
//        System.out.println(cnt);

        // 비트 마스킹 사용 풀이
        int cnt = 0;
        for (int i = 6; i >= 0; i--) {
//            X & 1<<i :
            if((X & (1<<i)) != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
