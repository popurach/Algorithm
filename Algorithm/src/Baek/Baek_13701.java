package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. HashSet을 통해 중복처리 후 Queue에 저장 후 출력
 * 2. BitSet을 통해 값이 기존에 없었으면 그대로 출력
 * */
public class Baek_13701 {
//    static String[] str;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        str = br.readLine().split(" ");
//
//        HashSet<Integer> set = new HashSet<>();
//        Queue<Integer> q = new LinkedList<>();
//
//        for (int i = 0; i < str.length; i++) {
//            int cur = Integer.parseInt(str[i]);
//            if(!set.contains(cur)) {
//                q.add(cur);
//                set.add(cur);
//            }
//        }
//        while(!q.isEmpty()){
//            sb.append(q.poll() + " ");
//        }
//        System.out.println(sb);
//    }

    static BitSet bs = new BitSet(33554432);
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = st.countTokens();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(!bs.get(cur)) {
                bs.set(cur);
                sb.append(cur + " ");
            }
        }
        System.out.println(sb);
    }
}
