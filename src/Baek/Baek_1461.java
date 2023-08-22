package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 도서관
 * 책이 0의 위치에 N권이 있고
 * 세준이는 한번에 최대 M권의 책을 들 수 있음
 * 책을 모두 제자리에 놔둘 때 드는 최소 걸음 수
 *
 * 음의 수, 양의 수 따로 입력
 * list에 큰 수 추가 + M-1 권 큐에서 제거
 * list 정렬 후 가장 큰 값이 가장 마지막에 가지러 가는 책
 * */
public class Baek_1461 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp > 0) {
                plus.offer(temp);
            } else {
                minus.offer(temp);
            }
        }

        while(!plus.isEmpty()) {
            list.add(plus.poll());
            for (int i = 0; i < M - 1; i++) {
                plus.poll();
                if(plus.isEmpty()) {
                    break;
                }
            }
        }

        while(!minus.isEmpty()) {
            list.add(Math.abs(minus.poll()));
            for (int i = 0; i < M - 1; i++) {
                minus.poll();
                if(minus.isEmpty()) {
                    break;
                }
            }
        }

        Collections.sort(list);
        int sum = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            sum += 2 * list.get(i);
        }
        sum += list.get(list.size() - 1);

        System.out.println(sum);
    }
}
