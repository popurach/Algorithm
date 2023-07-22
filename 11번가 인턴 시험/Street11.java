package Baek;

import java.util.HashMap;
import java.util.Map;

public class Street11 {

    public static void main(String[] args) {
//        System.out.println(solution("QABAAAAWOBL"));
    }

    /**
     * 1번 문제
     * 첫번째 문자를 맨 뒤로 보내는 방식을 반복한다
     * 이때, 첫번째 믄자와 마지막 문자가 같은 경우의 수
     * ex. "abbaa" -> "bbaaa" -> "baaab" -> "aaabb" -> "aabba"
     * */
//    static int solution(String S) {
//        int cnt = S.charAt(0) == S.charAt(S.length() - 1)? 1: 0;
//        int left = 0;
//
//        if(S.length() == 2) {
//            return cnt;
//        }
//        while(left < S.length()-1) {
//            if(S.charAt(left) == S.charAt(left + 1)) {
//                cnt++;
//            }
//            left++;
//        }
//        return cnt;
//    }


    /**
     * 2번 문제
     * BANNA가 들어가있는 문장이면 BANNA를 제거해줌. 몇 번 진행할 수 있는지
     * B:1개, A:3개, N:2개
     * HashMap을 이용하여 위 문자들 개수가 있다면 진행, 없다면 break
     * */
//    static int solution(String S) {
//        Map<Character, Integer> map = new HashMap<>();
//        int cnt = 0;
//
//        for(char s : S.toCharArray()) {
//            if(!map.containsKey(s)) {
//                map.put(s, 1);
//            } else {
//                map.replace(s, map.get(s) + 1);
//            }
//        }
//        while(true) {
//            if(map.containsKey('B') && map.containsKey('A') && map.containsKey('N') &&
//                    map.get('B') >= 1 && map.get('A') >= 3 && map.get('N') >=2) {
//                map.replace('B', map.get('B') - 1);
//                map.replace('A', map.get('A') - 3);
//                map.replace('N', map.get('N') - 2);
//            } else {
//                break;
//            }
//            cnt++;
//        }
//        return cnt;
//    }

    /**
     * 3번 문제
     * 인접한 문자가 서로 같을 때 하나를 지운다. 이때 최소 비용으로 지움
     * K번째 문자를 삭제하는데 드는 비용 => C[K]
     * ex. "abccbd" {0, 1, 2, 3, 4, 5} / "aabbcc" {1, 2, 1, 2, 1, 2}
     * */
//    static int solution(String S, int[] C) {
//        int cost = 0;
//        char cur, past;
//
//        past = S.charAt(0);
//        for (int i = 1; i < S.length(); i++) {
//            cur = S.charAt(i);
//            if(past == cur) {
//                cost += Math.min(C[i - 1], C[i]);
//            }
//            past = cur;
//        }
//        return cost;
//    }
}
