package Baek;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 입국 심사
 * 상근이와 친구 총 M명 <= 10억
 * 입국 심사대 총 N개 <= 10만 (1 <=Tk <=10억)
 *
 * 시간을 기준으로 이분 탐색
 * 최고 걸릴 시간 : maxTk * M
 * */
public class Baek_3079 {
    static long MAX_VALUE, resultTime;
    static int N, M;
    static Integer[] arr;
    static List<Integer> examination;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Integer[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        MAX_VALUE = (long)max * M;
        resultTime = MAX_VALUE;
        Arrays.sort(arr);
        binarySearch();
        System.out.println(resultTime);
    }
    static void binarySearch() {
        long lo = 0, hi = MAX_VALUE;

        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            long countPerson = 0;

            for (int i = 0; i < N; i++) {
                countPerson += mid / arr[i];

                if(countPerson >= M) {
                    break;
                }
            }
            if(countPerson >= M) {
                resultTime = Math.min(resultTime, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
    }
}
//    static class node implements Comparable<node>{
//        int originTime;
//        long totalTime;
//        boolean isChecked;
//
//        public node(int originTime, long totalTime, boolean isChecked) {
//            this.originTime = originTime;
//            this.totalTime = totalTime;
//            this.isChecked = isChecked;
//        }
//
//        @Override
//        public int compareTo(node o) {
//            return (int) ((this.totalTime + this.originTime) - (o.totalTime + o.originTime));
//        }
//
//    }
//    static int N, M;
//    static int[] T;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        PriorityQueue<node> pq = new PriorityQueue<>();
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i < N; i++) {
//            int temp = Integer.parseInt(br.readLine());
//            pq.offer(new node(temp, 0, false));
//        }
//        long max = 0;
//        for (int i = 0; i < M; i++) {
//            node cur = pq.poll();
//            pq.offer(new node(cur.originTime, cur.totalTime + cur.originTime, true));
//            max = Math.max(max, cur.totalTime + cur.originTime);
//        }
//        System.out.println(max);
//    }
//}
