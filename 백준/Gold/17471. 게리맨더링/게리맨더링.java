import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, result = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
	static int[] parents, num;
	static boolean[] numbers;
	static List<List<Integer>> graph;
	static void make() {
		parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a), bRoot = find(b);
		if(aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N + 1];
		numbers = new boolean[N + 1];
		
		graph = new ArrayList<>();
		
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; i <= Math.ceil(N/(double)2); i++) {
			comb(0, 1, i);
		}
		if(result==Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
	}
	static void comb(int cnt, int start, int n) {//조합
		if(cnt == n) {
			make();
			if(check()) {
				result = Math.min(result, min);
			}
			return;
		}
		for (int i = start; i <N + 1 ; i++) {
			numbers[i] = true;
			comb(cnt + 1, i + 1, n);
			numbers[i] = false;
		}
	}
	static boolean check() {
		List<Integer> l1 = new ArrayList<>();//선택
		List<Integer> l2 = new ArrayList<>();//선택 X
		int sum1 = 0, sum2 = 0, cnt1 = 0, cnt2 = 0;
		for (int i = 1; i < N + 1; i++) {
			if(numbers[i]) {
				sum1 += num[i];
				l1.add(i);
			}else {
				sum2 += num[i];
				l2.add(i);
			}
		}
		for (int i = 0; i < l1.size(); i++) {
			int a = l1.get(i);
			for (int j = 0; j < graph.get(a).size(); j++) {
				int b = graph.get(a).get(j);
				if(l1.contains(b)) {
					union(a, b);
				}
			}
		}
		for (int i = 0; i < l2.size(); i++) {
			int a = l2.get(i);
			for (int j = 0; j < graph.get(a).size(); j++) {
				int b = graph.get(a).get(j);
				if(l2.contains(b)) {
					union(a, b);
				}
			}
		}
		int c1 = l1.get(0), c2 = l2.get(0);
		for (int i = 1; i < l1.size(); i++) {
			if(find(c1)!=find(l1.get(i)))
				return false;
		}
		for (int i = 1; i < l2.size(); i++) {
			if(find(c2)!=find(l2.get(i)))
				return false;
		}
		min = Math.abs(sum1 - sum2);
		return true;
	}
}
