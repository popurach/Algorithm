package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek_1744 {
	static int N, cnt = 0;
	static double sum = 0;
	static PriorityQueue<Integer> pq;
	static PriorityQueue<Integer> pqMinus;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		pqMinus = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > 0) {
				pq.offer(temp);
			} else if(temp == 0) {
				cnt++;
			} else {
				pqMinus.offer(temp);
			}
		}
		
		while(pqMinus.size() >= 2) {
			int a = pqMinus.poll();
			int b = pqMinus.poll();
			
			sum += (a * b);
		}
		
		if(cnt > 0 && !pqMinus.isEmpty()) {
			pqMinus.poll();
		}
		
		while(pq.size() >= 2) {
			int a = pq.poll();
			int b = pq.poll();
			
			if(b >= 2) {
				sum += (a * b);
			} else {
				sum += (a + b);
			}
		}
		
		if(!pq.isEmpty() && !pqMinus.isEmpty()) {
			int a = pq.poll();
			int b = pqMinus.poll();
			
			if(a != 0) {
				sum += (a + b);
			}
		} else if(pq.isEmpty() && !pqMinus.isEmpty()) {
			sum += pqMinus.poll();
		} else if(!pq.isEmpty() && pqMinus.isEmpty()) {
			sum += pq.poll();
		}
		
		System.out.println((int)sum);
	}
}
