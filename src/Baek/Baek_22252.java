package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 정보 상인 호석
 * HashMap<String, PriorityQueue<Integer>>
 * map의 value로 우선순위큐 사용
 * */
public class Baek_22252 {
    static int Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();

        long sum = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if(q == 1) {
                if(map.containsKey(name)) {
                    PriorityQueue<Integer> pq = map.get(name);
                    for (int j = 0; j < k; j++) {
                        pq.add(Integer.parseInt(st.nextToken()));
                    }
                    map.replace(name, pq);
                } else {
                    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
                    for (int j = 0; j < k; j++) {
                        pq.add(Integer.parseInt(st.nextToken()));
                    }
                    map.put(name, pq);
                }
            } else if(q == 2) {
                if(map.containsKey(name)) {
                    if (k > map.get(name).size()) {
                        k = map.get(name).size();
                    }
                    for (int j = 0; j < k; j++) {
                        sum += map.get(name).poll();
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
