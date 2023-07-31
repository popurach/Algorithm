package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
/**
 * 세 수의 합
 * x + y + z = k (x, y, z, k 모두 arr에 속할 때 k의 최대 값)
 * x + y = k - z로 변형이 중요
 * x + y 값을 HashSet에 저장
 * */
public class Baek_2295 {
    static int N, max = 0;
    static Integer[] arr;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        for (int i = N-1; i >=0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(set.contains(arr[i] - arr[j])) {
                    max = Math.max(max, arr[i]);
//                    System.out.println(arr[i]);
//                    System.exit(0);
                }
            }
        }
        System.out.println(max);
    }

}
