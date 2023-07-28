import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Integer[] crane;
    static List<Integer> boxes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crane = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane, (a, b) -> b-a);

        M = Integer.parseInt(br.readLine());
        boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes, (a, b) -> b-a);

        if(crane[0] < boxes.get(0)) {
            System.out.println(-1);
            System.exit(0);
        }

        int cnt = 0;
        while(!boxes.isEmpty()) {
            int craneIdx = 0, idx = 0;

            while(craneIdx < N) {
                if(idx == boxes.size()) {
                    break;
                } else if(crane[craneIdx] >= boxes.get(idx)) {
                    boxes.remove(idx);
                    craneIdx += 1;
                } else {
                    idx += 1;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}