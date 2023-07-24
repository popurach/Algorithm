import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_1417 {
	static int N, dasom, num;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<Integer>((a, b)->(b - a));
		num = 0;
		
		dasom = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			if(cur >= dasom) {
				cur-=1;
				dasom+=1;
				pq.offer(cur);
				num++;
			}else {
				break;
			}
		}
		System.out.println(num);
	}	
}
