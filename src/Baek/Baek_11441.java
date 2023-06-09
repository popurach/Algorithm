package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11441 {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken());
			arr[i + 1] = sum;
		}
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(arr[end] - arr[start - 1] + "\n");
		}
		System.out.println(sb);
	}
}
