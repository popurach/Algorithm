package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 그리디 알고리즘 : S를 이용해서 T를 만들 수 있는지 => T로 S를 만들 수 있는지
 * 1. 문자열의 뒤에 A를 추가, 2. 문자열을 뒤집고 뒤에 B를 추가
 * => 1. A로 끝나면 A 제거, 2. B로 끝나면 B제거하고 뒤집어주기
 * 
 * 문자열 메소드
 * String.endsWith("str") : 해당 문자열이 str로 끝나는지
 * 문자열 뒤집기 (StringBuilder 사용)
 * StringBuilder("str").reverse().toString() 사용
 * */
public class Baek_12904 {
    static String S, T;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        while(T.length() > S.length()) {
            if(T.endsWith("A")) {
//            if(T.charAt(T.length() - 1) == 'A'){
                T = T.substring(0, T.length() - 1);
            } else {
                T = T.substring(0, T.length() - 1);
                T = new StringBuilder(T).reverse().toString();
//                T = rotate(T);
            }
        }
        if(T.equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static String rotate(String str) {
        String temp = "";
        for (int i = str.length() - 1; i >=0 ; i--) {
            temp += str.charAt(i);
        }
        return temp;
    }
}
