import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 수열의 크기, 홍준이의 질문의 개수
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int e = 1; e <= N; e++) {
            for (int s = 1; s <= e; s++) {
                if(e == s) {
                    dp[s][e] = 1;
                } else if(e - s == 1 || e - s == 2) {
                    dp[s][e] = arr[s] == arr[e]? 1: 0;
                } else {
                    if(arr[s] != arr[e] || dp[s + 1][e - 1] == 0) {
                        dp[s][e] = 0;
                    } else {
                        dp[s][e] = 1;
                    }
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] + "\n");
        }
        System.out.println(sb);
    }
}