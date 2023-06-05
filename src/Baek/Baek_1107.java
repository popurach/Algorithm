package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1107 {
	static int number, N, min = Integer.MAX_VALUE, closeNum = 0;
	static int[] numbers;
	static boolean[] isChecked;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		number = Integer.parseInt(br.readLine());
		
		// 자리수 구하기
		N = String.valueOf(number).length();
//		N = (int)(Math.log10(number) + 1);

		isChecked = new boolean[10];
		Arrays.fill(isChecked, true);
		
		int num = Integer.parseInt(br.readLine());
		
		if(num > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			for (int i = 0; i < num; i++) {
				isChecked[Integer.parseInt(st.nextToken())] = false;
			}
		}
		
		numbers = new int[N];
		perm(0, N);
		
		if(N > 1) {
			numbers = new int[N - 1];
			perm(0, N - 1);
		}
		
		numbers = new int[N + 1];
		perm(0, N + 1);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(Math.abs(number - 100));
		} else {
			int sum = Math.min(Math.abs(number - 100), min);
			System.out.println(sum);
		}
	}
	
	static void perm(int cnt, int length) {
		if(cnt == length) {
			int sum = 0;
			for (int i = 0; i < length; i++) {
				sum += (numbers[i] * Math.pow(10, i));
			}
			int temp = Math.abs(number - sum) + String.valueOf(sum).length();
			if(min > temp) {
				min = temp;
			}
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if(isChecked[i]) {
				numbers[cnt] = i;
				perm(cnt + 1, length);
			}
		}
	}
}
