package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * HashMap 사용
 */
public class Baek_10816 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
	
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(map.containsKey(temp)) {
				map.replace(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(map.containsKey(temp)) {
				sb.append(map.get(temp) + " ");
			} else {
				sb.append(0 + " ");
			}
		}
		System.out.println(sb);
		
		// HashMap keySet을 이용한 반복문
		System.out.println("HashMap keySet을 이용한 반복문");
		for (Integer key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
		
		// HashMap 람다식을 이용한 반복문
		System.out.println("HashMap 람다식을 이용한 반복문");
		map.forEach((key, value) -> {
			System.out.println(key + " " + value);
		});
	}
}
