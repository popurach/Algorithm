import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int[] stick = { 64, 32, 16, 8, 4, 2, 1 };//막대기가 가질 수 있는 길이의 경우의 수
	static int X;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		X = Integer.parseInt(br.readLine());//목표 막대 길이 입력
		System.out.print(get_Num(X));
	}

	static int get_Num(int x) {//막대의 개수 출력 함수
		int cnt = 0;
		for (int i = 0; i < 7; i++) {
			if (x >= stick[i]) {//만약 현재 남아있는 막대의 길이보다 같거나 작다면
				x -= stick[i];//풀로 붙일 막대에 포함 => 남아있는 막대의 길이에서 빼줍니다
				cnt++;//퓰로 붙일 막대의 개수 ++
			}
			if (x == 0) {//만약 풀로 붙일 막대를 모두 선택했다면
				break;
			}
		}
		return cnt;
	}
}
