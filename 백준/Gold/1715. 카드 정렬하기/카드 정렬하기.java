import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		if(N ==1) {
			System.out.println(0);
		} else {
			int sum = 0;
			while(pq.size() >=2) {
				int temp = pq.poll() + pq.poll();
				sum += temp;
				pq.offer(temp);
			}
			System.out.println(sum);
		}
	}
}