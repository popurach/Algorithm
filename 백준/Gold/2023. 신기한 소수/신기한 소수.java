import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            if(isPrime(i)) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if(cur >= Math.pow(10, N-1)) {
                    sb.append(cur + "\n");
                    continue;
                }
                for (int j = cur * 10; j < (cur + 1) * 10; j++) {
                    if(isPrime(j)) {
                        q.offer(j);
                    }
                }
            }
        }
        System.out.println(sb);
    }
    static boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}