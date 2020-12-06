package pack180801_multiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class JUC04_CopyArrayOnWriteArrayList {
//д�벢����,CopyOnWriteArrayList��ÿ��д��ʱ�����Ḵ�ƣ�����һ���µ��б��ٽ�����ӣ���Ϊÿ�ζ�Ҫ���ƣ������ܴ��ʺ����ڵ���
//��Ӳ�����ʱ��Ч�ʵͣ���������������ʱ������ѡ��
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
			//һ�����list��һ�����Ԫ�أ����������޸��쳣��һ���߳̾ͻᷢ������쳣
		}
	}
	
}
