import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_1057 {
	static int N;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	static boolean[] isVisited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		isVisited = new boolean[N + 1];
		perm(0);
		System.out.println(sb);
	}
	static void perm(int cnt) {
		if(cnt==N) {
			for (int a : numbers) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(isVisited[i]) {
				continue;
			}
			isVisited[i] = true;
			numbers[cnt] = i;
			perm(cnt + 1);
			isVisited[i] = false;
		}
	}
}
