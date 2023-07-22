package Baek;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();

		HashSet<String> colors = new HashSet<>(Arrays.asList("Red", "Black", "Yellow", "Purple"));
		
		// ������ �Է��ϱ�
		set.add(1);
		set.add(2);
		System.out.println(set.size());
		System.out.println(set);
		
		
		
		// HashSet ������ ����ϱ�
		
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
		
		// HashSet ������Ʈ ����
		
		colors.remove("Red");
		colors.removeIf(color -> color.startsWith("B"));
		
		
		// HashSet �� ���� ���� Ȯ��
		
		System.out.println(colors.contains("Green"));
	}
}
