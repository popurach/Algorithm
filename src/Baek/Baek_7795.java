package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_7795 {
	static int N, M;
	static int[] arr1, arr2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr1 = new int[N];
			arr2 = new int[M];
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr2);
			
			for (int i = 0; i < N; i++) {
				if(arr2[0] < arr1[i]) {
					sum += binary(arr1[i]);
				}
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
	static int binary(int num) {
		int lo = 0, hi = M - 1;
		while(lo <= hi) {
			int mid = (arr2[(lo + hi)/2]);
			
			if(mid >= num) {
				hi = (lo + hi)/2 - 1;
			} else {
				lo = (lo + hi)/2 + 1;
			}
//			System.out.println("mid : " + mid);
		}
		return lo;
	}
}
