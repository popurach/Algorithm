import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, L, cnt = 0;
    static boolean[] isChecked;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        graph = new int[N][N];
        isChecked = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로 이동
        for (int i = 0; i < N; i++) {
            int cur = 0;
            Arrays.fill(isChecked, false);
            while(cur < N-1) {
                if(graph[i][cur] == graph[i][cur + 1]) {
                    cur += 1;
                } else {
                    if(Math.abs(graph[i][cur] - graph[i][cur + 1]) > 1) {
                        break;
                    }
                    if(graph[i][cur] < graph[i][cur + 1]) { // 오르막
                        if(checkAsc(true, i, cur + 1)) {
                            for (int j = cur + 1 - L; j <= cur; j++) {
                                isChecked[j] = true;
                            }
                            cur += 1;
                        } else {
                            break;
                        }
                    } else { // 내리막
                        if(checkDesc(true, i, cur)) {
                            for (int j = cur + 1; j <= cur + L; j++) {
                                isChecked[j] = true;
                            }
                            cur += L;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(cur == N-1) {
                cnt += 1;
            }
        }
        
        // 세로 이동
        for (int j = 0; j < N; j++) {
            int cur = 0;
            Arrays.fill(isChecked, false);
            while(cur < N-1) {
                if(graph[cur][j] == graph[cur + 1][j]) {
                    cur += 1;
                } else {
                    if(Math.abs(graph[cur][j] - graph[cur + 1][j]) > 1) {
                        break;
                    }
                    if(graph[cur][j] < graph[cur + 1][j]) { // 오르막
                        if(checkAsc(false, j, cur + 1)) {
                            for (int i = cur + 1 - L; i <= cur; i++) {
                                isChecked[i] = true;
                            }
                            cur += 1;
                        } else {
                            break;
                        }
                    } else { // 내리막
                        if(checkDesc(false, j, cur)) {
                            for (int i = cur + 1; i <= cur + L; i++) {
                                isChecked[i] = true;
                            }
                            cur += L;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(cur == N-1) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
    static boolean checkAsc(boolean col, int cur, int idx) {
        // 현재 인덱스를 기준으로 (idx - L, idx - 1) 값이 같은지 확인
        if(idx - L < 0 || isChecked[idx - L]) {
            return false;
        }
        if(col) { // 가로
            for (int j = idx - L; j < idx - 2; j++) {
                if(graph[cur][j] != graph[cur][j + 1]) {
                    return false;
                }
            }
            return true;
        } else { // 세로
            for (int i = idx - L; i < idx - 2; i++) {
                if(graph[i][cur] != graph[i + 1][cur]) {
                    return false;
                }
            }
            return true;
        }
    }
    static boolean checkDesc(boolean col, int cur, int idx) {
        // 현재 인덱스를 기준으로 (idx + 1, idx + L) 값이 같은지 확인
        if(idx + L >= N) {
            return false;
        }
        if(col) { // 가로
            for (int j = idx + 1; j < idx + L; j++) {
                if(graph[cur][j] != graph[cur][j + 1]) {
                    return false;
                }
            }
            return true;
        } else { // 세로
            for (int i = idx + 1; i < idx + L; i++) {
                if(graph[i][cur] != graph[i + 1][cur]) {
                    return false;
                }
            }
            return true;
        }
    }
}