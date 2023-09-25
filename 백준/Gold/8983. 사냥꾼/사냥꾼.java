import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int M, N, L; // 사대의 수, 동물의 수, 사정거리
    static int[] loc;
    static List<int[]> animals;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        loc = new int[M];
        animals = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            loc[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(loc);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals.add(new int[]{x, y});
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int[] cur = animals.get(i);
            int lo = 0, hi = M, mid = -1;
            while(lo <= hi) {
                mid = (lo + hi)/2;

                if(mid >= M) {
                    break;
                }
                int l = cur[1] + Math.abs(cur[0] - loc[mid]);
                if(L >= l) {
                    cnt += 1;
                    break;
                } else if(loc[mid] >= cur[0]) {
                    hi -= 1;
                } else {
                    lo += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}