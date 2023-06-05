package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
// 이분탐색
public class Baek_1920 {
	static int N, M;
	static int[] A, B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(binary(temp)) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		System.out.println(sb);
	}
	static boolean binary(int num) {
		int lo = 0;
		int hi = A.length - 1;
		
		while(lo <= hi) {
			int temp = A[(lo + hi)/2]; 
			if(num == temp) {
				return true;
			} else if (num > temp) {
				lo = (lo + hi)/2 + 1;
				continue;
			} else {
				hi = (lo + hi)/2 -1;
				continue;
			}
		}
		return false;
	}
}
