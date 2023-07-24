package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 내려가기
 * Top-Down 방식 - 재귀함수
 * Bottom-Up 방식 - 반복문 + 슬라이드 윈도우 방식
 * */
public class Baek_2096 {
    static int N;
    static int[] maxDp, minDp;
    static int[][] dpMax, dpMin, graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new int[N][3];

        maxDp = new int[3];
        minDp = new int[3];

//        dpMax = new int[N][3];
//        dpMin = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
//            Arrays.fill(dpMax[i], -1);
//            Arrays.fill(dpMin[i], -1);
        }
        for (int i = 0; i < 3; i++) {
            maxDp[i] = graph[0][i];
            minDp[i] = graph[0][i];
        }

        /**
         * Bottom-Up 방식 + 슬라이드 윈도우
         * */
        for (int i = 1; i < N; i++) {
            int prevMaxValue_0 = maxDp[0], prevMaxValue_2 = maxDp[2];
            maxDp[0] = Math.max(maxDp[0], maxDp[1]) + graph[i][0];
            maxDp[2] = Math.max(maxDp[1], maxDp[2]) + graph[i][2];
            maxDp[1] = Math.max(maxDp[1], Math.max(prevMaxValue_0, prevMaxValue_2)) + graph[i][1];

            int prevMinValue_0 = minDp[0], prevMinValue_2 = minDp[2];
            minDp[0] = Math.min(minDp[0], minDp[1]) + graph[i][0];
            minDp[2] = Math.min(minDp[1], minDp[2]) + graph[i][2];
            minDp[1] = Math.min(minDp[1], Math.min(prevMinValue_0, prevMinValue_2)) + graph[i][1];
        }
        sb.append(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " ");
        sb.append(Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
        System.out.println(sb);
//        sb.append(Math.max(maxScore(N-1, 0), Math.max(maxScore(N-1, 1), maxScore(N-1, 2))) + " ");
//        sb.append(Math.min(minScore(N-1, 0), Math.min(minScore(N-1, 1), minScore(N-1, 2))));
//        System.out.println(sb);
    }
    /**
     * Top-Down 재귀함수 방식
     * */
    static int maxScore(int i, int j) {
        if(i < 0) {
            return 0;
        }
        if(dpMax[i][j] != -1) {
            return dpMax[i][j];
        }
        dpMax[i][j] = 1000000;
        if(j == 0) {
            dpMax[i][j] = Math.max(maxScore(i-1, 0),maxScore(i-1, 1)) + graph[i][j];
        } else if(j == 1) {
            dpMax[i][j] = Math.max(maxScore(i-1, 0), Math.max(maxScore(i-1, 1), maxScore(i-1, 2))) + graph[i][j];
        } else {
            dpMax[i][j] = Math.max(maxScore(i-1, 1),maxScore(i-1, 2)) + graph[i][j];
        }
        return dpMax[i][j];
    }
    static int minScore(int i, int j) {
        if(i < 0) {
            return 0;
        }
        if(dpMin[i][j] != -1) {
            return dpMin[i][j];
        }
        dpMin[i][j] = 0;
        if(j == 0) {
            dpMin[i][j] = Math.min(minScore(i-1, 0),minScore(i-1, 1)) + graph[i][j];
        } else if(j == 1) {
            dpMin[i][j] = Math.min(minScore(i-1, 0), Math.min(minScore(i-1, 1), minScore(i-1, 2))) + graph[i][j];
        } else {
            dpMin[i][j] = Math.min(minScore(i-1, 1),minScore(i-1, 2)) + graph[i][j];
        }
        return dpMin[i][j];
    }
}
