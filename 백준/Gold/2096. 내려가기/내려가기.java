import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dpMax, dpMin, graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new int[N][3];
        dpMax = new int[N][3];
        dpMin = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
            Arrays.fill(dpMax[i], -1);
            Arrays.fill(dpMin[i], -1);
        }
        sb.append(Math.max(maxScore(N-1, 0), Math.max(maxScore(N-1, 1), maxScore(N-1, 2))) + " ");
        sb.append(Math.min(minScore(N-1, 0), Math.min(minScore(N-1, 1), minScore(N-1, 2))));
        System.out.println(sb);
    }
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