package pack180801_multiThread;

public class JUC03_CompareAndSwap {
//模拟cas
	public static void main(String[] args) {
		final CompareAndSwap cas = new CompareAndSwap();
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int expectValue = cas.get();
					boolean b = cas.compareAndSet(expectValue, (int)(Math.random()*101));
					System.out.println(b);
				}
			}).start();
		}
	}

}

class CompareAndSwap{
	private int value;
	//获取内存值
	public synchronized int get(){
		return value;
	}
	//比较和替换
	public synchronized int compareAndSwap(int exceptValue,int newValue){
		int oldValue = value;
		if(oldValue == exceptValue){
			this.value = newValue;
		}
		return value;
	}
	//设置
	public synchronized boolean compareAndSet(int exceptValue,int newValue){
		return exceptValue == compareAndSwap(exceptValue, newValue);
	}
}
