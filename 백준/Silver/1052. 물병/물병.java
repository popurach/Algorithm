import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비트마스킹
 *
 * */
public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while(true) {
            if(Integer.bitCount(N) <= K) {
                System.out.println(cnt);
                break;
            }
            N += 1;
            cnt++;
        }
    }
}