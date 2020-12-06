package pack180801_multiThread;

public class W2_Daemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaemonT t = new DaemonT();
//		t.setDaemon(true);
		t.start();
		System.out.println("结束");
	}

}

class DaemonT extends Thread{
	public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("RUN方法执行");
	}
}
