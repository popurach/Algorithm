import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static int n, k;
    static int[] numbers;
    static boolean[] isVisited;
    static Set<String> set;
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        set = new HashSet<>();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        numbers = new int[k];
        isVisited = new boolean[n];
        perm(0);
        System.out.println(set.size());
    }
    static void perm(int cnt) {
        if(cnt == k) {
            String temp = "";
            for (int i = 0; i < k; i++) {
                temp += list.get(numbers[i]);
            }
            if(!set.contains(temp)) {
                set.add(temp);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                numbers[cnt] = i;
                perm(cnt + 1);
                isVisited[i] = false;
            }
        }
    }
}