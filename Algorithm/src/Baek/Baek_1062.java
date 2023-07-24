package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1062 {
    static int N, K, max = 0;
    static List<String> states;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        states = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            states.add(input.substring(4, input.length() - 4));
        }
        if(K < 5) {
            System.out.println(0);
            System.exit(0);
        } else if(K == 26) {
            System.out.println(N);
            System.exit(0);
        }
        isVisited = new boolean[26]; //antic는 true
        isVisited['a' - 'a'] = isVisited['n' - 'a'] = isVisited['t' - 'a']
                = isVisited['i' - 'a'] = isVisited['c' - 'a'] = true;
        comb(0, 0);
        System.out.println(max);
    }
    static void comb(int cnt, int start) {
        if(cnt == K - 5) {
            int count = 0;
            for (int i = 0; i < states.size(); i++) {
                String cur = states.get(i);
                boolean flag = true;
                for (int j = 0; j < cur.length(); j++) {
                    if(!isVisited[cur.charAt(j) - 'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    count++;
                }
            }
            if(max < count) max = count;

            return;
        }
        for (int i = start; i < 26; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            comb(cnt + 1, i + 1);
            isVisited[i] = false;
        }
    }
}
