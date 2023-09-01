import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] arr, numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		numbers = new char[L];
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		comb(0, 0);
	}
	static void comb(int cnt, int start) {
		if(cnt==L) {
			check(Arrays.copyOf(numbers, L));
			return;
		}
		for (int i = start; i < C; i++) {
			numbers[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}
	static void check(char[] a) {
		int cnt_mo = 0, cnt_za = 0;
		for (char c : a) {
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
				cnt_mo++;
			}else {
				cnt_za++;
			}
		}
		if(cnt_mo>=1 && cnt_za>=2) {
			System.out.println(a);
		}
	}
}
