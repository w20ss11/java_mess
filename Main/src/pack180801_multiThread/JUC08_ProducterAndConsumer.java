package pack180801_multiThread;

public class JUC08_ProducterAndConsumer {
//生产者和消费者案例
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Productor pro = new Productor(clerk);
		Consumer cos = new Consumer(clerk);
		new Thread(pro,"生产者A").start();
		new Thread(cos,"消费者B").start();
		
		/**
		 * 问题:生产者线程过快，不断发数据，另一边已经不可以接收，会产生数据丢失
		                消费者线程过快，不断接收数据，另一边没有发送，可能产生重复的数据或者错误的数据
		        解决:等待唤醒机制
		                  如果产品满了，就wait(),等消费者通知，如果添加成功，就notifyall()通知可以卖货
		                  如果缺货，就wait()， 如果成功取走产品，说明有空位了，就可以通知生产者继续生产
		 */
	}

}
class Clerk{//店员
	private int product = 0;
	//进货
	public synchronized void get(){//有10个货位
		if(product>=10){
			System.out.println("产品已满");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			//货位没有满 店员添加一个货
			System.out.println(Thread.currentThread().getName()+":"+ ++product);
			this.notifyAll();
		}
	}
	//卖货
	public synchronized void sale(){
		if(product<=0){
			System.out.println("缺货！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName()+":"+ --product);
			this.notifyAll();
		}
	}
}
class Productor implements Runnable{//生产者
	private Clerk clerk;
	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			clerk.get();
		}
	}
}
class Consumer implements Runnable{//消费者
	private Clerk clerk;
	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			clerk.sale();
		}
	}
}