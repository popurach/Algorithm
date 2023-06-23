import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        str = br.readLine().split(" ");

        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < str.length; i++) {
            int cur = Integer.parseInt(str[i]);
            if(!set.contains(cur)) {
                q.add(cur);
                set.add(cur);
            }
        }
        while(!q.isEmpty()){
            sb.append(q.poll() + " ");
        }
        System.out.println(sb);
    }
}