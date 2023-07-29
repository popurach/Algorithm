import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashMap<String, List<Integer>> map = new HashMap<>();

        long sum = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if(q == 1) {
                if(map.containsKey(name)) {
                    List<Integer> C = map.get(name);
                    for (int j = 0; j < k; j++) {
                        C.add(Integer.parseInt(st.nextToken()));
                    }
                    Collections.sort(C, (a, b)->b-a);
                    map.replace(name, C);
                } else {
                    List<Integer> C = new ArrayList<>();
                    for (int j = 0; j < k; j++) {
                        C.add(Integer.parseInt(st.nextToken()));
                    }
                    Collections.sort(C, (a, b) -> b - a);
                    map.put(name, C);
                }
            } else if(q == 2) {
                if(map.containsKey(name)) {
                    List<Integer> C = map.get(name);
                    if (k > C.size()) {
                        k = C.size();
                    }
                    for (int j = 0; j < k; j++) {
                        sum += C.remove(0);
                    }
                }
            }
        }
        System.out.println(sum);
    }
}