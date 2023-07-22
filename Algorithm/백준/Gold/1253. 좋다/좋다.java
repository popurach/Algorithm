import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		list = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			list.add(temp);
			if(!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				map.replace(temp, map.get(temp) + 1);
			}
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		int cnt = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int temp = list.get(i) + list.get(j);
				if(map.containsKey(temp)) {
					if(list.get(i) == 0 && list.get(j) == 0) { // 둘 다 0일 때
						if(map.get(temp) <= 2) {
							continue;
						}
					} else if(list.get(i) == 0 || list.get(j) == 0) { // 하나만 0일 때
						if(map.get(temp) <= 1) {
							continue;
						}
					} 
					cnt += map.get(temp);
					map.remove(temp);
				}
			}
		}
		System.out.println(cnt);
	}
}