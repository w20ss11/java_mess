package pack180801_jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class GCDemo7 {

	public static void main(String[] args){
		// สำฦต19
		Object obj = new Object();
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		PhantomReference<Object> ref = new PhantomReference<Object>(obj,queue);
		System.out.println(queue.poll());
		obj = null;
		System.gc();
		System.out.println(ref.get());
		System.out.println(queue.poll());

	}

}
