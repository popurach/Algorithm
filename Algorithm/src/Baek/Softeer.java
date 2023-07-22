package Baek;

import java.io.*;
import java.util.*;

// 그래프 탐색 하나는 나오고, 정렬 쓰는 문제 나오거나 소수점 둘째 자리에서 반올림 해서 출력 하는 문제 , 그리고 이분탐색
public class Softeer {
	static class Fruit implements Comparable<Fruit>{
		private String name;
		private int price;
		
		public Fruit(String name, int price) {
			this.name = name;
			this.price = price;
		}
		@Override
		public String toString() {
			return "name : " + name + " price : " + price;
		}
		@Override
		public int compareTo(Fruit fruit) {
			return this.name.length() - fruit.name.length();
		}
	}
	static List<Integer>[] list;
	static int N, M;// 체육관의 개수, 체육관 사이의길의 개수
	static List<Integer>[] graph;
	public static void main(String[] args) throws Exception{
		list = new ArrayList[N + 1];
		
		// Lambda를 사용한 정렬
		Integer[] arr = {2, 5, 8, 6, 0, 4, 1, 3};
		
		List<Integer> testArr = new ArrayList<>();
		for(int i=0; i<arr.length; i++)
			testArr.add(arr[i]);

		// 내림차순 정렬 8 6 5 ...
		Collections.sort(testArr, (a, b) -> b - a);

		for (int i = 0; i < testArr.size(); i++) {
			System.out.println(testArr.get(i));
		}

		// 오름차순 정렬
		Arrays.sort(arr, (a, b) -> a - b);
		System.out.println(Arrays.toString(arr));
		
		// String 정렬
		String[] strArr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
//		Arrays.sort(strArr, Collections.reverseOrder());
		Arrays.sort(strArr, (a, b) -> a.length() - b.length());
		System.out.println(Arrays.toString(strArr));

		// class - Comparable 정렬
		Fruit[] fruitArr = {
		        new Fruit("Apple", 100),
		        new Fruit("Kiwi", 500),
		        new Fruit("Orange", 200),
		        new Fruit("Banana", 50),
		        new Fruit("Watermelon", 880),
		        new Fruit("Cherry", 10)
		};

		Arrays.sort(fruitArr);

		System.out.println("Sorted arr[] : " + Arrays.toString(fruitArr));
		
		// 자리수 구하기
		int number = 458754;
		N = String.valueOf(number).length();
		System.out.println("자리수 : " + N);
		
		// 반올림 하기 (소수점 둘째 자리에서)
		double pie = 3.1415926535;
		pie = Math.round(pie * 10) / 10.0;
		System.out.println(pie);
		
		
		// 문자열 메소드
		String str1 = "문자열을 공부해봅시다";
		String str2 = "abcdef";
		
		// 1. indexOf : 문자열에서 특정 문자가 시작되는 인덱스를 리턴
		System.out.println(str2.indexOf("bacd"));
		
		// 2. length() : 문자열의 길이를 반환
		System.out.println(str1.length());
		
		// 3. substring : 문자열 중 특정 부분을 뽑아낼 때 사용
		System.out.println(str1.substring(5, 8)); // -> 공부해
		
		// 4. 
		char[] test = str1.toCharArray();
		System.out.println(test.length);
	}
	// 소수 판정
	static boolean checkPrime(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
