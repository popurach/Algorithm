package Baek;

public class BitSet {

    public static void main(String[] args) {
        java.util.BitSet bits1 = new java.util.BitSet();
        java.util.BitSet bits2 = new java.util.BitSet();

        bits1.set(0);
        bits1.set(2);
        bits1.set(3);
        bits1.set(5);

        bits2.set(1);
        bits2.set(2);
        bits1.set(6);

        // 논리적 AND
//        bits1.and(bits2);

        // 논리적 OR
        bits1.or(bits2);

        // 논리적 XOR
//        bits1.xor(bits2);

        // 논리적 NOT
//        bits1.flip(0, bits1.length());  // 모든 비트 값을 반전

        // 비트 값 출력
        System.out.println(bits1);  // 비트 값 출력
    }

}
