package Baek;
/**
 * https://reakwon.tistory.com/84
 * 참고 URL
 * */
class MyThread extends Thread {
	public MyThread(String threadName) {
		super(threadName);
	}
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName() + " " + i);
		}
		System.out.println();
	}
}

// Runnable 인터페이스를 구현한 클래스를 Thread의 생성자로 주입하여 실행하는 방법
class MyThread2 implements Runnable{
	private String threadName;
	
	public MyThread2(String threadName) {
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(threadName + " : " + i);
		}
	}
}
public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("MainThread Start");
		Thread[] thread = new Thread[4];
		
		for (int i = 1; i <= 3; i++) {
			/*
			 * 다음 방식들은 join을 사용하지 못하므로 뒤죽박죽 실행됨
			 * 
			 * <Thread 클래스 상속하는 방법>
			 * new MyThread("Thread" + i).start();
			 * 
			 * <Runnable 인터페이스 구현법>
			 * Thread thread = new Thread(new MyThread2("Thread" + i)); 
			 * thread.start(); 
			*/
			
			
			thread[i] = new Thread(new MyThread2("Thread" + i));
			thread[i].start();
			
//			이 곳에서 join을 걸어주면 thread 하나가 완전히 끝나고 다음 thread가 실행됨
//			thread[i].join();
		}
		
//		join이라는 메소드를 통해서 분기를 어떤 지점에 합칠 수 있음. 쓰레드를 생성한 쓰레드는 그 지점에서 기다려야함.
		for (int i = 1; i <= 3; i++) {
			thread[i].join();
		}
		System.out.println("MainThread End");
	}
}
