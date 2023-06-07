package Baek;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();

		HashSet<String> colors = new HashSet<>(Arrays.asList("Red", "Black", "Yellow", "Purple"));
		
		
		// 데이터 입력하기
		set.add(1);
		set.add(2);
		System.out.println(set.size());
		System.out.println(set);
		
		
		
		// HashSet 데이터 출력하기
		
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
		System.out.println();
		
		set.forEach(value -> {
			System.out.print(value + " ");
		});
		System.out.println();
		
		colors.forEach(value -> {
			System.out.print(value + " ");
		});
		System.out.println();
		
		// HashSet 엘레먼트 삭제
		
		colors.remove("Red");
		colors.removeIf(color -> color.startsWith("B"));
		
		
		// HashSet 값 존재 유무 확인
		
		System.out.println(colors.contains("Green"));
	}
}
