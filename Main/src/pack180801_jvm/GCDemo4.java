package pack180801_jvm;

import java.lang.ref.SoftReference;
//��Ƶ16 17
public class GCDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object object = new Object();//ǿ����
		Object ref = object;//���ô���  ����һ���ռ��������ջָ��object��ref��
		object = null;//�Ͽ���һ������
		System.gc();
		System.out.println(ref);
		
		Object obj = new Object();
		SoftReference<Object> soft_ref = new SoftReference<Object>(obj);
		obj = null;//�Ͽ�����
		System.gc();
		System.out.println(soft_ref);//�ռ�������ڣ���Ȼû�б�ջobj���ã�����soft_ref���ã���ʱ�ռ����

	}

}
