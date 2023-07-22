package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * HashMap 이용
 * 
 * */
public class Baek_19583 {
	static class student{
		String startTime;
		String endTime;
		
		public student(String startTime, String endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}
		@Override
		public boolean equals(Object obj) {
			return this.hashCode() == obj.hashCode();
		}
		@Override
		public int hashCode() {
			return startTime.hashCode() + endTime.hashCode();
		}
		@Override
		public String toString() {
			return this.startTime + " " + this.endTime;
		}
	}
	static String S, E, Q;
	static int STime, ETime, QTime, cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, student> hashmap = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = st.nextToken(); // 개강총회 시작 시간
		E = st.nextToken(); // 개강총회 끝낸 시간
		Q = st.nextToken(); // 스트리밍 끝낸 시간
		
		STime = timeMapping(S);
		ETime = timeMapping(E);
		QTime = timeMapping(Q);
		
		String str = br.readLine();
		
		while(str != null && !str.isEmpty()) {
			String[] arr = str.split(" ");
			
			String time = arr[0];
			String name = arr[1];
			
			if(hashmap.containsKey(name)) {
				if(timeMapping(time) >= ETime && timeMapping(time) <= QTime) {
					student s = new student(hashmap.get(name).startTime, time);
					hashmap.replace(name, s);
				}
			} else {
				hashmap.put(name, new student(time, time));
			}
			
			str = br.readLine();
		}
		
		hashmap.forEach((key, value) -> {
			if(timeMapping(value.startTime) <= STime && timeMapping(value.endTime) >= ETime 
					&& timeMapping(value.endTime) <= QTime) {
				cnt+=1;
			}
		});
		System.out.println(cnt);
	}
	static int timeMapping(String str) {
		String[] arr = str.split(":");
		return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
	}
}
