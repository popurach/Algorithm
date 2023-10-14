import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class member {
        int age, seq;
        String name;
        public member(int age, String name, int seq) {
            this.age = age;
            this.name = name;
            this.seq = seq;
        }
    }
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        PriorityQueue<member> pq = new PriorityQueue<>((a, b) -> {
            if(a.age == b.age) {
                return a.seq - b.seq;
            }
            return a.age - b.age;
        });

        int seq = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.offer(new member(age, name, seq));
            seq+=1;
        }
        while(!pq.isEmpty()) {
            member cur = pq.poll();
            sb.append(cur.age + " " + cur.name + "\n");
        }
        System.out.println(sb);
    }
}