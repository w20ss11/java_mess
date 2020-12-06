package pack180801_jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class GCDemo6 {

	public static void main(String[] args) throws InterruptedException {
		// ��Ƶ19
		Object obj = new Object();
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		WeakReference<Object> ref = new WeakReference<Object>(obj,queue);
		System.out.println(queue.poll());
		obj = null;
		System.gc();
		Thread.sleep(200);//gc���ӳ�
		System.out.println(queue.poll());

	}

}
