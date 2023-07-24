import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int T, n, m;
    static long cnt = 0;
    static int[] A, B;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        A = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken()) + A[i - 1];
        }

        m = Integer.parseInt(br.readLine());

        B = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            B[i] = Integer.parseInt(st.nextToken()) + B[i - 1];
        }

        Map<Integer, Integer> Amap = new HashMap<>();
        Map<Integer, Integer> Bmap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = A[i] - A[j];
                Amap.put(temp, Amap.getOrDefault(temp, 0) + 1);
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = B[i] - B[j];
                if(Amap.containsKey(T - temp)) {
                    cnt += Amap.get(T - temp);
                }
//                Bmap.put(temp, Bmap.getOrDefault(temp, 0) + 1);
            }
        }
//
//        Amap.forEach((key, value) -> {
//            if(Bmap.containsKey(T - key)) {
//                cnt += value * Bmap.get(T - key);
//            }
//        });
        System.out.println(cnt);
    }
}