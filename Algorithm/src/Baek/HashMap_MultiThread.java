package Baek;

import java.util.HashMap;
import java.util.Map;

/**
 * 의도 : thread라는 쓰레드에서 hashmap의 저장된 데이터 seoul ~ daejeon의 데이터를 모두 출력
 * 
 * 메인 쓰레드와 thread간의 HashMap에 동시에 접근했기 때문에 위 코드에 예외가 발생
 * */
public class HashMap_MultiThread {
	static Map<String, String> hashmap = new HashMap<>();
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Thread() {
			@Override
			public void run() {
				hashmap.put("Seoul", "02");
				hashmap.put("kyeongkido", "031");
				hashmap.put("busan", "051");
				hashmap.put("daejeon","042");
				hashmap.forEach((key, value) -> {
					try {
						Thread.sleep(1000);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("{" + key + "," + value + "}");
				});
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		Thread.sleep(1000);
		// 메인 스레드에서 put 메소드로 데이터를 저장 -> 두 스레드가 동시에 HashMap에 접근
		// 결론 : HashMap은 쓰레드에 대해서 안전하지 않은 컬렉션 -> HashTable을 사용
		hashmap.put("jeju", "064");
	}
}
