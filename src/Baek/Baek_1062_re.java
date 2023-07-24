package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비트 마스킹을 이용한 영어 단어 저장
 * */
public class Baek_1062_re {
    static int N, K, max = 0, isVisited;
    static int[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new int[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for(char c : input.toCharArray()) {
                words[i] |= (1 << c - 'a');
            }
        }
        if(K < 5) {
            System.out.println(0);
            System.exit(0);
        } else if(K == 26) {
            System.out.println(N);
            System.exit(0);
        }
//        isVisited = (1<<26) - 1; //antic는 true

        isVisited |= (1<<'a' - 'a');
        isVisited |= (1<<'n' - 'a');
        isVisited |= (1<<'t' - 'a');
        isVisited |= (1<<'i' - 'a');
        isVisited |= (1<<'c' - 'a');

        comb(0, 0);
        System.out.println(max);
    }
    static void comb(int cnt, int start) {
        if(cnt == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if((words[i] & isVisited) == words[i]){
                    count++;
                }
            }
            if(max < count) max = count;

            return;
        }
        for (int i = start; i < 26; i++) {
            if((isVisited & (1<<i)) != 0) continue;
            // 비트 켜기
            isVisited |= (1<<i);
            comb(cnt + 1, i + 1);
            // 비트 끄기
            isVisited &= ~(1<<i);
        }
    }
}