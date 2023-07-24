package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 파라메트릭 서치 (이분탐색과 동일하면서 정렬을 필요로 하지 않음)
// ex. 
// 예산 : 200 [10, 20, 30, 290]
// lo   hi   mid
//  0   290  145 => 10 + 20 + 30 + 145 = 205
//  0   144  72  => 10 + 20 + 30 + 72 = 132
// 73   144  108 => 168
// 109  144  126 => 186
// 127  144  135 => 195
// 136  144  140 => 200
// 141  144  142 => 202
// 141  141  141 => 201
// 141  140

public class Baek_2512 {
	static int N, M, total = 0, max = Integer.MIN_VALUE;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		M = Integer.parseInt(br.readLine());
		if(total <= M) {
			System.out.println(max);
			return;
		}
		binary();
	}
	static void binary() {
		int lo = 0, hi = max;
		
		while(lo <= hi) {
			int mid = (lo + hi)/2;
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				if(arr[i] > mid) {
					sum += mid; //최대 예산을 넘는 경우
				} else {
					sum += arr[i];
				}
			}
			System.out.println(lo + " " + hi + " " + mid);
			if(sum > M) { // 사용 가능 예산보다 더 큰 경우
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		System.out.println(hi);
	}
}
