package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 소트게임
 * 문자열의 일부 범위를 뒤집었을 때 오름차순이 나오는 최소 횟수
 * BFS -> String 함수를 이용 (substring, reverse)
 * */
public class Baek_1327 {
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
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        problem = br.readLine().replace(" ", "");
        arr = problem.toCharArray();
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
            StringBuilder sb = new StringBuilder();
            game cur = q.poll();
            if(cur.sentence.equals(answer)) {
                System.out.println(cur.cnt);
                return;
            }
            for (int i = 0; i <= cur.sentence.length() - K; i++) {
                String temp =
                        cur.sentence.substring(0, i) +
                        sb.append(cur.sentence, i, i + K).reverse() +
                        cur.sentence.substring(i + K, cur.sentence.length());
                sb.setLength(0);
                if(!set.contains(temp)) {
                    q.offer(new game(temp, cur.cnt + 1));
                    set.add(temp);
                }
            }
        }
        System.out.println(-1);
    }
}
