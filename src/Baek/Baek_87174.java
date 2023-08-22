package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 센서
 * 그리디 + 정렬
 * N개의 센서 + K개의 집중국
 * 각 센서들의 길이 차이 -> 우선순위큐 내림차순 정렬
 * sum 변수에 각 센서들 길이 차이 합
 * K-1개 우선순위큐 값 뻄
 * */
public class Baek_87174 {
    static int N, K, sum = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if(N <= K) {
            System.out.println(0);
            System.exit(0);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < N - 1; i++) {
            pq.offer(arr[i + 1] - arr[i]);
            sum += arr[i + 1] - arr[i];
        }

        for (int i = 0; i < K-1; i++) {
            sum -= pq.poll();
        }
        System.out.println(sum);
    }
}
