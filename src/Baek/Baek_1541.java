package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 잃어버린 괄호
 * +, -, 그리고 괄호를 가지고 식
 * 괄호를 적절히 쳐서 이 식의 값을 최소
 *
 * 1. str.trim("[-]")로 -를 구분자로 String 배열 형성
 * 2. str.trim("[+]")로 + 구분자로 더해주는 함수
 * */
public class Baek_1541 {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] formula = str.split("-");

        // ** 여러 문자열로 나누고 싶을 때는 [] 안에 나열 **
        String[] arr = str.split("[+-]");
        System.out.println(Arrays.toString(arr));

        sum = getSum(formula[0]);
        if(formula.length > 1) {
            for (int i = 1; i < formula.length; i++) {
                sum -= getSum(formula[i]);
            }
        }
        System.out.println(sum);
    }
    static int getSum(String temp) {
        int total = 0;
//        String[] formula = temp.split("\\+");
        String[] formula = temp.split("[+]");
        for (int i = 0; i < formula.length; i++) {
            total += Integer.parseInt(formula[i]);
        }
        return total;
    }
}
