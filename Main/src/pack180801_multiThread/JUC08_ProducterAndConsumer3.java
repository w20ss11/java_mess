package pack180801_multiThread;

public class JUC08_ProducterAndConsumer3 {
//生产者和消费者案例
	public static void main(String[] args) {
		Clerk3 clerk = new Clerk3();
		Productor3 pro = new Productor3(clerk);
		Consumer3 cos = new Consumer3(clerk);
		new Thread(pro,"生产者A").start();
		new Thread(pro,"生产者B").start();
		new Thread(cos,"消费者C").start();
		new Thread(cos,"消费者D").start();
		
		/**
		 * 问题:出现了负数
		 * 原因:一个消费者缺货，在（1）处wait，然后被另一个消费者抢到资源，也在（1）出wait
		                  生产者notifyall将两个消费者唤醒，都从（1）出继续执行，进行--product操作，称为虚假唤醒
		 * 解决:wait使用在循环中（if改为while），使得消费者（或者生产者）在被唤醒时，再去判断一次
		 */
	}

}
class Clerk3{//店员
	private int product = 0;
	//进货
	public synchronized void get(){//有10个货位
		while(product>=1){
			System.out.println("产品已满");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//货位没有满 店员添加一个货
		System.out.println(Thread.currentThread().getName()+":"+ ++product);
		this.notifyAll();
	}
	//卖货
	public synchronized void sale(){
		while(product<=0){
			System.out.println("缺货！");
			try {
				this.wait();//（1）
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+":"+ --product);
		this.notifyAll();
	}
}
class Productor3 implements Runnable{//生产者
	private Clerk3 clerk;
	public Productor3(Clerk3 clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.get();
		}
	}
}
class Consumer3 implements Runnable{//消费者
	private Clerk3 clerk;
	public Consumer3(Clerk3 clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			clerk.sale();
		}
	}
}