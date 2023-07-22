package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_re_2512 {
	static int N, M, lo = 0, hi = Integer.MIN_VALUE, max = 0;
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		int total = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			total += num[i];
			if(hi < num[i]) {
				hi = num[i];
			}
		}
		M = Integer.parseInt(br.readLine());
		if(total <= M) {
			System.out.println(hi);
		} else {
			binary();
		}
	}
	static void binary() {
		while(lo <= hi) {
			int mid = (lo + hi) /2;
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				if(num[i] > mid) {
					sum += mid;
				} else {
					sum += num[i];
				}
			}
			if(sum > M) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		System.out.println(hi);
	}
}
