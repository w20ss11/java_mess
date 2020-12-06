package pack180801_multiThread;

public class JUC08_ProducterAndConsumer2 {
//生产者和消费者案例
	public static void main(String[] args) {
		Clerk2 clerk = new Clerk2();
		Productor2 pro = new Productor2(clerk);
		Consumer2 cos = new Consumer2(clerk);
		new Thread(pro,"生产者A").start();
		new Thread(cos,"消费者B").start();
		
		/**
		 * 问题:程序没停
		 * 原因:消费者线程循环次数最后一次，生产者线程剩下2次，product=0时：
		                  消费者获取到资源，开始消费，produce<=0所以“缺货”，wait()（1），被唤醒后，在（1）处继续往下执行，此时消费者循环次数剩下为0，释放锁资源
		                  然后生产者拿到资源，循环次数剩下1次，判断出product=0，添加货，然后notifyall()，释放锁资源，接下来生产者和消费者同时抢锁资源
		                 消费者又抢到资源，从（1）出开始往下执行，已经判断为if，else不能执行，所以就彻底结束了
		                 然后生产者拿到资源，product此时为1，产品已满，开始wait，没有其他线程唤醒这个锁
		 * 解决:去掉notifyall()前面的else
		 */
	}

}
class Clerk2{//店员
	private int product = 0;
	//进货
	public synchronized void get(){//有10个货位
		if(product>=1){
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
		if(product<=0){
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
class Productor2 implements Runnable{//生产者
	private Clerk2 clerk;
	public Productor2(Clerk2 clerk) {
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
class Consumer2 implements Runnable{//消费者
	private Clerk2 clerk;
	public Consumer2(Clerk2 clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			clerk.sale();
		}
	}
}