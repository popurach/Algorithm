package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 적록색약 dfs 풀이
 * 각 칸에 R, G, B => 각 영역의 개수 구하기
 * 적록색약은 R == G 로 보임
 * */
public class Baek_10026 {
    static int N, cnt = 0;
    static boolean[][] isChecked;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] graph, blindGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        blindGraph = new char[N][N];
        isChecked = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                graph[i][j] = temp.charAt(j);
                if(graph[i][j] == 'G') {
                    blindGraph[i][j] = 'R';
                } else {
                    blindGraph[i][j] = graph[i][j];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!isChecked[i][j]) {
                    cnt++;
                    isChecked[i][j] = true;
                    nonBlind(new int[] { i, j }, graph[i][j]);
                }
            }
        }
        sb.append(cnt + " ");
        cnt = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(isChecked[i], false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!isChecked[i][j]) {
                    cnt++;
                    isChecked[i][j] = true;
                    blind(new int[] { i, j }, blindGraph[i][j]);
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
    static void nonBlind(int[] cur, char condition) {
        for (int i = 0; i < dir.length; i++) {
            int ni = cur[0] + dir[i][0];
            int nj = cur[1] + dir[i][1];

            if(ni<0 || nj<0 || ni>N-1 || nj>N-1 || isChecked[ni][nj] || graph[ni][nj] != condition) {
                continue;
            }
            isChecked[ni][nj] = true;
            nonBlind(new int[]{ni, nj}, condition);
        }
    }
    static void blind(int[] cur, char condition) {
        for (int i = 0; i < dir.length; i++) {
            int ni = cur[0] + dir[i][0];
            int nj = cur[1] + dir[i][1];

            if(ni<0 || nj<0 || ni>N-1 || nj>N-1 || isChecked[ni][nj] || blindGraph[ni][nj] != condition) {
                continue;
            }
            isChecked[ni][nj] = true;
            blind(new int[]{ni, nj}, condition);
        }
    }
}
