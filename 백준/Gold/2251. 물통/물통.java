import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int A, B, C;
    static int[] arr;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[]{A, B, C};
        set = new TreeSet<>();
        bfs();

        for(int s : set) {
            System.out.print(s + " ");
        }
    }
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isChecked = new boolean[A + 1][B + 1];

        q.offer(new int[]{0, 0, arr[2]});
        isChecked[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == 0) {
                set.add(cur[2]);
            }
            for (int i = 0; i < 3; i++) { // from
                for (int j = 0; j < 3; j++) { // to
                    if(i != j) {
                        int[] next = Arrays.copyOf(cur, cur.length);
                        if(next[i]  + next[j] > arr[j]) {
                            next[i] -= arr[j] - next[j];
                            next[j] = arr[j];
                            if(!isChecked[next[0]][next[1]]) {
                                isChecked[next[0]][next[1]] = true;
                                q.offer(new int[]{next[0], next[1], next[2]});
                            }
                        } else {
                            next[j] += next[i];
                            next[i] = 0;
                            if(!isChecked[next[0]][next[1]]) {
                                isChecked[next[0]][next[1]] = true;
                                q.offer(new int[]{next[0], next[1], next[2]});
                            }
                        }
                    }
                }
            }
        }
    }
}