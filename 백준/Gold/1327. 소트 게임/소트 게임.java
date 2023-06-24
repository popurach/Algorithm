import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class game {
        String sentence;
        int cnt;
        public game(String sentence, int cnt) {
            this.sentence = sentence;
            this.cnt = cnt;
        }
    }
    static int N, K;
    static String problem = "", answer = "";
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            problem += arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            answer += arr[i];
        }

        bfs();
    }
    static void bfs() {
        Queue<game> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.offer(new game(problem, 0));
        set.add(problem);

        while(!q.isEmpty()) {
            game cur = q.poll();
            if(cur.sentence.equals(answer)) {
                System.out.println(cur.cnt);
                return;
            }
            for (int i = 0; i <= cur.sentence.length() - K; i++) {
                String temp =
                        cur.sentence.substring(0, i) +
                        new StringBuilder(cur.sentence.substring(i, i + K)).reverse().toString() +
                        cur.sentence.substring(i + K, cur.sentence.length());
                if(!set.contains(temp)) {
                    q.offer(new game(temp, cur.cnt + 1));
                    set.add(temp);
                }
            }
        }
        System.out.println(-1);
    }
}