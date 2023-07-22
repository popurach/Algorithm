import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 누적 합 + 해시 맵
 * */
public class Main {
    static int N, K;
    static int[] arr;
    static long cnt = 0; //  ( N * (N + 1) / 2 ) 값이 20억을 넘으므로 ( N <= 20만 ) long 타입
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        // 누적합 배열
        for (int i = 1; i <= N; i++) {
            arr[i] += Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        // Sj - Si = K 에서 i <= j 이므로 i = j일 때,
        // 항상 Sj - Si = 0인 경우가 1개 있음
        map.put(0, 1);
        for (int i = 1; i <= N; i++) {
            // Sj <- arr[i]   Si <- map.get(arr[i] - k)
            // Sj - k = Si
            cnt += map.getOrDefault(arr[i] - K, 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(cnt);
    }
}