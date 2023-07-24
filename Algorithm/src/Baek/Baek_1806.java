package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1806 {
	static int N, S;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}
		
		int min = Integer.MAX_VALUE;
		
		int left = 1;
		int right = 1;
		
		while(left <= right) {
			if(arr[right] - arr[left - 1] >= S) {
				min = Math.min(min, right - left + 1);
				left += 1;
			} else {
				right += 1;
			}
			if(left < 1 || right > N) {
				break;
			}
		}
		System.out.println(min == Integer.MAX_VALUE? 0: min);
	}
}
