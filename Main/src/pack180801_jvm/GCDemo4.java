package pack180801_jvm;

import java.lang.ref.SoftReference;
//视频16 17
public class GCDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object object = new Object();//强引用
		Object ref = object;//引用传递  所以一个空间对象被两个栈指向（object和ref）
		object = null;//断开了一个连接
		System.gc();
		System.out.println(ref);
		
		Object obj = new Object();
		SoftReference<Object> soft_ref = new SoftReference<Object>(obj);
		obj = null;//断开连接
		System.gc();
		System.out.println(soft_ref);//空间对象仍在，虽然没有被栈obj引用，但被soft_ref引用，此时空间充足

	}

}
