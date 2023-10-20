import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
    static int N, M, L, lo = 1, hi = 1, answer;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        list.add(0);
        list.add(L);
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort((a, b) -> a-b);

        hi = L;
        answer = L;
        while(lo <= hi) {
            int mid = (lo + hi)/2;

            int cnt = 0;
            for (int i = 1; i < list.size(); i++) {
                cnt += (list.get(i) - list.get(i-1) - 1)/mid;
            }

            if(cnt > M) {
                lo = mid + 1;
            } else {
                answer = Integer.min(answer, mid);
                hi = mid - 1;
            }
        }
        System.out.println(answer);
    }
}