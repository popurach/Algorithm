import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 비트 마스킹
 * */
public class Main {
    static int X;
//    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        
        // 비트 마스킹 사용 풀이
        int cnt = 0;
        for (int i = 6; i >= 0; i--) {
            if((X & (1<<i)) != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}