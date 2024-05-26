import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, max;
	static int[] Selected;
	static int[][] castle;
	static ArrayList<Enemy> elist;// 적들 정보 저장하는 리스트

	static class Enemy {
		int x, y;

		public Enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 행
		M = Integer.parseInt(st.nextToken());// 열
		D = Integer.parseInt(st.nextToken());// 유효거리
		Selected = new int[3];
		elist = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					elist.add(new Enemy(i, j));
			}
		}
//		System.out.println(Arrays.deepToString(castle));
		comb(0, 0);
		System.out.println(max);
	}

	static void comb(int cnt, int start) {// 궁수 위치 조합 MC3
		if (cnt == 3) {
//			System.out.println(Arrays.toString(Selected));
			fire();
			return;
		}
		for (int i = start; i < M; i++) {
			Selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void fire() {// 궁수 조합이 완성될 때마다 호출
		ArrayList<Enemy> copy = new ArrayList<>();
		for (Enemy e : elist) {
			copy.add(new Enemy(e.x, e.y));
		}

		int killed = gameStart(copy, Selected);
		max = Math.max(max, killed);
	}

	private static int gameStart(ArrayList<Enemy> list, int[] archers) {
		int cnt = 0;
		while (list.size() != 0) {
			ArrayList<Enemy> tmp = new ArrayList<>();
			for (int y : archers) {
				int targetIndex = findNear(list, y);

				if (targetIndex >= 0) {// 죽일 적이 있다면?
					tmp.add(list.get(targetIndex));// 궁수 3명이 죽일 적 임시 리스트에 저장
				}
			}
			for (Enemy e : tmp) {
				if (list.remove(e))
					cnt++;
			}
			enemyDown(list);//살아남은 적 정보만 있는 리스트 전달
		}

		return cnt;
	}

	private static int findNear(ArrayList<Enemy> list, int y) {
		int index = -1;
		int minDistance = Integer.MAX_VALUE;//적과 궁수간 가장 가까운 거리
		int minColumn = Integer.MAX_VALUE;//발견된 적의 칼럼값. 가장 왼쪽 찾기
		
		for (int i = 0; i < list.size(); i++) {
			Enemy e = list.get(i);
			
			int d = (N - e.x) + Math.abs(y-e.y);
			if(d > D)//유효거리 넘어서면
				continue;
			if(d < minDistance) {
				minDistance = d;
				minColumn = e.y;
				index = i;
			}else if(d == minDistance) {
				if(minColumn > e.y) {
					minColumn = e.y;
					index = i;
				}
			}
		}
		return index;
	}
	
	private static void enemyDown(ArrayList<Enemy> list) {
		Iterator<Enemy> it = list.iterator();
		while(it.hasNext()) {
			Enemy e = it.next();
			e.x++;
			
			if(e.x == N) {
				it.remove();
			}
		}
	}

	

}
