import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        while(T.length() > S.length()) {
//            if(T.endsWith("A")) {
            if(T.charAt(T.length() - 1) == 'A'){
                T = T.substring(0, T.length() - 1);
            } else {
                T = T.substring(0, T.length() - 1);
                T = rotate(T);
            }
        }
        if(T.equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static String rotate(String str) {
        String temp = "";
        for (int i = str.length() - 1; i >=0 ; i--) {
            temp += str.charAt(i);
        }
        return temp;
    }
}