import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Baek_1316 {
	static int N, cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] temp = str.toCharArray();
			if(check(temp)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static boolean check(char[] temp) {
		HashMap< Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < temp.length; i++) {
			if(map.containsKey(temp[i])) {
				map.put(temp[i], map.get(temp[i]) + 1);
			}else {
				map.put(temp[i], 1);
			}
		}
		
		return true;
	}
}
