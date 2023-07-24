package Baek;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Baek_6236 {
//	static int N, M;
//	static int[] pay;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		pay = new int[N];
//		
//		int max = Integer.MIN_VALUE, sum = 0;
//		for (int i = 0; i < N; i++) {
//			pay[i] = Integer.parseInt(br.readLine());
//			max = Math.max(max, pay[i]);
//			sum += pay[i];
//		}
//		
//		int lo = max, hi = sum;
//		
//		while(lo <= hi) {
//			int mid = (lo + hi) /2;
//			int temp = payPossible(mid);
//			
//			if(temp == 0) {
//				lo = mid + 1;
//			} else {
//				hi = mid - 1;
//			}
//		}
//		System.out.println(lo);
//	}
//
///**
////	 * M 횟수 내에 지불이 가능한지 판단하는 함수
////	 * 0 : M 횟수를 초과
////	 * 1 : 정확히 M 횟수
////	 * -1 : M 횟수보다 작음
////	 * */
//	static int payPossible(int withdraw) {
//		int curMoney = 0;
//		int curCount = 0;
//		
//		for (int i = 0; i < N; i++) {
//			if(curMoney < pay[i]) {
//				curCount++;
//				if(curCount > M) {
//					return 0;
//				}
//				curMoney = withdraw;
//			}
//			curMoney -= pay[i];
//		}
//		return curCount == M? 1: -1; 
//	}
//}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_6236 {
	static int N, M, max = Integer.MIN_VALUE;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		
		int lo = max, hi = max * N;
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			int temp = possiblePay(mid);
			
			if(temp == 0) {
				lo = mid + 1;
			} else { // -1 일 때
				hi = mid - 1;
			}
		}
		System.out.println(lo);
	}
	
	/**
	 * M 횟수 내에 지불이 가능한지 판단하는 함수
	 * 0 : M 횟수를 초과
	 * 1 : 정확히 M 횟수
	 * -1 : M 횟수보다 작음
	 * */
	static int possiblePay(int withdraw) {
		int curSum = 0;
		int curCount = 0;
		
		for (int i = 0; i < N; i++) {
			if(arr[i] > curSum) {
				curCount++;
				curSum = withdraw;
				if(curCount > M) {
					return 0;
				}
			}
			curSum -= arr[i];
		}
		return curCount == M? 1: -1;
	}
}