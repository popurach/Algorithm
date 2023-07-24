package Baek;

import java.util.HashMap;
import java.util.Map;

public class HashMap_Class {
	static class Person{
		private String name;
		private String id;
		public Person(String name, String id) {
			super();
			this.name = name;
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		
		@Override
		public String toString() {
			return this.name;
		}

		// hasCode는 각 객체가 갖는 유일한 값(Code)을 의미 -> HashMap은 hashCode()가 반환하는 값이 다르면 equals 수행하지 않음
		@Override
		public int hashCode() {
			return name.hashCode() + id.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return this.hashCode() == obj.hashCode();
		}

		
		// hashCode가 다르면 equals 함수 실행도 하지 않음
//		@Override
//		public boolean equals(Object o) {
//			if(o instanceof Person) {
//				Person p = (Person)o;
//				return this.id.equals(p.id) && this.name.equals(p.name);
//			}
//			return false;
//		}
		
	}
	public static void main(String[] args) {
		Person person1=new Person("reakwon","666666-7777777");
		Person person2=new Person("putty","123456-1234567");
		
		Person who=new Person("reakwon","666666-7777777");
		Map<Person,Integer> map=new HashMap<>();
		map.put(person1, 90);
		map.put(person2, 80);
		
		System.out.println("map includes "+who.getName()+"? "+map.containsKey(who));
	
		map.put(who, 70);
		System.out.println(map);
	}
}
