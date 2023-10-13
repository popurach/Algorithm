import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int g, s;
    static String arrW, arrS;
    static int[] numbers, answers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        g = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arrW = br.readLine();
        arrS = br.readLine();

        numbers = new int[58];
        answers = new int[58];

        int count = 0;
        for (int i = 0; i < g; i++) {
            numbers[arrS.charAt(i) - 'A'] += 1;
            answers[arrW.charAt(i) - 'A'] += 1;
        }
        if(check()) {
            count += 1;
        }
        for (int i = 1; i <= s - g; i++) {
            int prev = arrS.charAt(i - 1) - 'A';
            int next = arrS.charAt(i + g - 1) - 'A';

            numbers[prev] -= 1;
            numbers[next] += 1;

            if(check()) {
                count += 1;
            }
        }
        System.out.println(count);
    }
    static boolean check() {
        for (int i = 0; i < g; i++) {
            if(numbers[arrW.charAt(i) - 'A'] != answers[arrW.charAt(i) - 'A']) {
                return false;
            }
        }
        return true;
    }
}