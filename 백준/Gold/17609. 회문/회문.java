import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            boolean flag = true, remove = true;
            sb.append(check(str, 0, str.length()-1, flag, remove) + "\n");
        }
        System.out.println(sb);
    }
    static int check(String str, int lo, int hi, boolean flag, boolean remove) {
        while(lo <= hi) {
            if(str.charAt(lo) == str.charAt(hi)) {
                lo += 1;
                hi -= 1;
            } else {
                if(remove) {
                    remove = false;

                    if(check(str, lo + 1, hi, flag, remove) != 2 || check(str, lo, hi - 1, flag, remove) != 2) {
                        break;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) {
            if(remove) {
               return 0;
            } else {
                return 1;
            }
        } else {
            return 2;
        }
    }
}