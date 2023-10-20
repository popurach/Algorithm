import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static int[] numbers;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N < 10) {
            System.out.println(N);
        } else {
            list = new ArrayList<>();

            for (int i = 1; i <= 10; i++) {
                numbers = new int[i];
                comb(0, 0, i);
            }
            list.sort((a, b) -> a - b);

            if(N >= list.size()) {
                System.out.println(-1);
            } else if (N == list.size()-1){
                System.out.println("9876543210");
            } else {
                System.out.println(list.get(N));
            }
        }

    }
    static void comb(int start, int cnt, int n) {
        if(cnt == n) {
            Arrays.sort(numbers);
            int sum = 0;
            for (int i = n-1; i >= 0; i--) {
                sum += Math.pow(10, i) * numbers[i];
            }
//            System.out.println(Arrays.toString(numbers) + " sum : " + sum);
            list.add(sum);
            return;
        }
        for (int i = start; i <= 9; i++) {
            numbers[cnt] = i;
            comb(i + 1, cnt + 1, n);
        }
    }
}