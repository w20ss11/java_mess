package pack180801_multiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class JUC04_CopyArrayOnWriteArrayList {
//写入并复制,CopyOnWriteArrayList在每次写入时，都会复制，复制一个新的列表再进行添加；因为每次都要复制，开销很大，适合用于迭代
//添加操作多时，效率低，并发迭代操作多时，可以选择
	public static void main(String[] args) {
		HelloThread ht = new HelloThread();
		for(int i=0;i<10;i++){
			new Thread(ht).start();
		}
	}

}

class HelloThread implements Runnable{
//	private static List<String> list = Collections.synchronizedList(new ArrayList<String>());

	private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
	
	static{
		list.add("aa");
		list.add("bb");
		list.add("cc");
	}
	@Override
	public void run() {
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			list.add("A");
			//一遍迭代list，一遍添加元素，发生并发修改异常，一个线程就会发生这个异常
		}
	}
	
}
