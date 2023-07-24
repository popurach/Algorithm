import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] formula = str.split("-");

        sum = getSum(formula[0]);
        if(formula.length > 1) {
            for (int i = 1; i < formula.length; i++) {
                sum -= getSum(formula[i]);
            }
        }
        System.out.println(sum);
    }
    static int getSum(String temp) {
        int total = 0;
        String[] formula = temp.split("\\+");
        for (int i = 0; i < formula.length; i++) {
            total += Integer.parseInt(formula[i]);
        }
        return total;
    }
}