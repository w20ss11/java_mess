package pack180801_multiThread;

public class JUC12_Thread8Monitor {
/**
 * 题目：判断打印的是“one”还是“two”
 * 1. 两个普通同步方法，两个线程，标准打印		           结果：one two（没有sleep语句，立即打印）
 * 2. 新增Thread.sleep()方法 给getOne       结果：one two（3s之后两个一起打印出来）
 * 3. 新增普通方法getThree()				结果：three one two（立马打印three，过3s打印one two）
 * 4. 两个普通同步方法，两个Number对象，打印                 结果：two one（two立即出来，one等3s）
 * 5. 修改getOne为静态同步方法，打印                                结果：two one（two立即出来，one等3s）
 * 6. 修改两个均为静态同步方法，一个Number对象             结果：one two（3s后两个一起打印出来）
 * 7. 一个是静态同步方法，一个非静态同步方法，两个Number对象   结果：two one（two立即出来，one等3s）
 * 8. 两个均为静态同步方法，两个Number对象                                     结果：one two（3s后两个一起打印出来）
 * 
 * 线程八锁的关键：
 * 1.非静态方法的锁默认为：this，静态方法的锁为 对应Class实例（Number.class）
 * 2.某一时刻内，只能有一个线程持有锁，无论几个方法
 * */
	public static void main(String[] args) {
		final Number number = new Number();
		final Number number2 = new Number();
		new Thread(new Runnable() {
			@Override
			public void run() {
				number.getOne();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				number2.getTwo();
//				number.getTwo();
			}
		}).start();
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				number.getThree();
//			}
//		}).start();
	}

}
class Number{
	public static synchronized void getOne(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("one");
	}
	public static synchronized void getTwo(){
		System.out.println("two");
	}
	public void getThree(){
		System.out.println("three");
	}
}
