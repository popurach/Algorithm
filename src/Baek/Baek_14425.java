package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek_14425 {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, 0);
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if(map.containsKey(str)) {
				cnt++;
				map.replace(str, map.get(str) + 1);
			}
		}
		System.out.println(cnt);
	}
}
