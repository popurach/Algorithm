package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 불!
 * 지훈이, 불 매 분마다 한칸씩 수평 또는 수직으로 이동
 * 불 bfs -> 지훈 bfs
 * */
public class Baek_4179 {
    static int R, C;
    static boolean flag;
    static char[][] graph;
    static boolean[][] isVisited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> human, fire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        isVisited = new boolean[R][C];
        human = new LinkedList<>();
        fire = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = str.charAt(j);
                if(graph[i][j] == 'J') {
                    human.offer(new int[]{i, j});
                    isVisited[i][j] = true;
                    graph[i][j] = '.';
                } else if(graph[i][j] == 'F') {
                    fire.offer(new int[]{i, j});
                }
            }
        }
        int temp = bfs();
        System.out.println(temp == -1? "IMPOSSIBLE": temp);
    }
    static int bfs() {
        int cnt = 0;

        while(!human.isEmpty()) {
            cnt+=1;
            // 불
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                int[] curFire = fire.poll();
                for (int j = 0; j < dir.length; j++) {
                    int ni = curFire[0] + dir[j][0];
                    int nj = curFire[1] + dir[j][1];

                    if(ni<0 || nj<0 || ni>R-1 || nj>C-1 || graph[ni][nj] != '.') {
                        continue;
                    }
                    fire.offer(new int[]{ni, nj});
                    graph[ni][nj] = 'F';
                }
            }

            // 지훈
            size = human.size();
            for (int i = 0; i < size; i++) {
                int[] curHuman = human.poll();
                for (int j = 0; j < dir.length; j++) {
                    int ni = curHuman[0] + dir[j][0];
                    int nj = curHuman[1] + dir[j][1];

                    if(ni<0 || nj<0 || ni>R-1 || nj>C-1) {
                        flag = true;
                        return cnt;
                    } else if(graph[ni][nj] == '#' || graph[ni][nj] == 'F' || isVisited[ni][nj]) {
                        continue;
                    }
                    human.offer(new int[]{ni, nj});
                    isVisited[ni][nj] = true;
                }
            }
        }
        return -1;
    }
}
