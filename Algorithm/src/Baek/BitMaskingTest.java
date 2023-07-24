package Baek;

public class BitMaskingTest {

    public static void main(String[] args) {
        int alphabets = (1<<26) - 1;
        System.out.println("알파벳 용 : " + Long.toBinaryString(alphabets));

        // 공집합과 꽉 찬 집합 구하기 (11 1111 1111)
        int A = 0;
        int B = 12;
//        (1<<10) -> 100 0000 0000
//        A = (1<<10) -1; // 11 1111 1111
        A = (1<<10);
        System.out.println(Integer.toBinaryString(A));
        // 원소 추가 (합집합 사용)
        A |= (1<<3);
        System.out.println(Integer.toBinaryString(A));
        // 원소 삭제 (교집합 사용)
        // 1. (1<<k) k번째가 켜진 상태
        // 2. ~(1<<k) k번째만 꺼진 상태
        // 3. A &= ~(1<<k) A 집합에 담긴 k번째 상태 off
//        A &= ~(1<<3);


        // 원소의 포함 여부 확인
        if((A & (1 << 3)) == (1<<3)) {
            System.out.println("포함합니다");
        }

        /**
         * A의 보수 구하기 (-A = ~A + 1)
         * A가 7일 때 A : 0000 0111
         *
         * 1. 비트를 반전시킨다 ~A : 1111 1000
         * 2. 1을 더한다 -A = ~A + 1 : 1111 1001
         *
         * 따라서 최소 원소 (첫 번째 켜진 비트)를 찾을 때
         * A & (-A)를 사용한다!
         * */

        /**
         * 두 집합에 대한 연산
         * */
        // 1. 합집합
        System.out.println("합집합 : " + Integer.toBinaryString(A | B));

        // 2. 교집합
        System.out.println("교집합 : " + Integer.toBinaryString(A & B));

        // 3. 차집합 -> A에서 B를 뺀 차집합
        System.out.println("차집합 : " + Integer.toBinaryString(B & (~A)));

        // 4. A와 B 중 하나에만 포함된 원소들의 집합
        System.out.println("A와 B 중 하나에만 포함된 원소들의 집합 : " + Integer.toBinaryString(A ^ B));

        System.out.println(Integer.toBinaryString(A));

        // 집합의 크기 구하기
        System.out.println(Integer.bitCount(B) + " " + bitCount(B));

        // 최소 원소 찾기
        int first = A & (-A);
        System.out.println(first);

        // 최소 원소 지우기
        A &= (A - 1);

        // 모든 부분 집합 순회하기
        System.out.println("B : " + B);
        for (int subset = B; subset > 0 ; subset = ((subset - 1) & B)) {
            System.out.println("부분집합 순회 : " + subset);
        }


    }
    /**
     * 집합의 크기 구하기
     * Integer.bitCount로 구현되어 있음
     * */
    static int bitCount(int A) {
        if(A == 0) return 0;
        return A % 2 + bitCount(A/2);
    }
}
