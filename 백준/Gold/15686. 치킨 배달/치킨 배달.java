import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] numbers;
	static int N, M, sum, real_Sum = Integer.MAX_VALUE;
	static List<int[]> li_h; static List<int[]> li_c;
	static List<int[]> temp = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		li_h = new ArrayList<>();
		li_c = new ArrayList<>();
		
		arr = new int[N][N];
		numbers = new int[13];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==1) {
					li_h.add(new int[] {i, j});
				}else if(arr[i][j]==2) {
					li_c.add(new int[] {i, j});
				}
			}
		}
		comb(0, 0);
		System.out.println(real_Sum);
	}
	//조합
	static void comb(int cnt, int start) {
		if(cnt==M) {
			sum = 0;
			for (int i = 0; i < li_h.size(); i++) {
				
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					// temp : 임의의 집 한 곳에서 각 치킨집들과의 거리
					int temp1 = Math.abs(temp.get(j)[0] - li_h.get(i)[0]) +  Math.abs(temp.get(j)[1] - li_h.get(i)[1]);
					min = Math.min(temp1, min);
				}
				sum+=min;
			}
			//System.out.println(sum);
			real_Sum = Math.min(real_Sum, sum);
			return;
		}
		for(int i = start; i<li_c.size(); i++) {
			temp.add(li_c.get(i));
			comb(cnt+1, i+1);
			temp.remove(li_c.get(i));
		}
	}
}
