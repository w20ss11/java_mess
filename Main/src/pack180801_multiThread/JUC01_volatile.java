package pack180801_multiThread;

public class JUC01_volatile {
	//valatile：当多个线程进行操作共享数据时，数据是可见的。
	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();
//		while(true)
//			if(td.isFlag()){
//				System.out.println("-----------");
//				break;
//			}
		
//		while(true)
//			synchronized (td) {
//				if(td.isFlag()){
//					System.out.println("-----------");
//					break;
//				}
//			}
		while(true)
			if(td.isFlag()){
				System.out.println("-----------");
				break;
			}
			

	}

}

class ThreadDemo implements Runnable{

	private volatile boolean flag = false;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = true;
		System.out.println("flag="+isFlag());
	}
	
}
