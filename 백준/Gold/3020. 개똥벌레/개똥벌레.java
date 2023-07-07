import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, H, min; //N : 동굴의 길이, H : 동굴의 높이
    static int[] top, bot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        top = new int[H + 1];
        bot = new int[H + 1];

        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(i%2 != 0) { //석순
                top[temp]++;
            } else { // 종유석
                bot[H - temp + 1]++;
            }
        }
        for (int i = H; i >= 2; i--) {
            top[i - 1] += top[i];
        }
        for (int i = 1; i < H; i++) {
            bot[i + 1] += bot[i];
        }
        min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            int calc = top[i] + bot[i];
            if(min > calc) {
                min = calc;
                cnt = 1;
            } else if(min == calc) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}