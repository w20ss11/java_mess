package pack180801_multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class JUC06_Callable {
//����ִ���̵߳ķ�ʽ����ʵ��callable�ӿ�,�����ʵ��Runnable�ӿڵķ�ʽ�����������з���ֵ�����ҿ����׳��쳣
	public static void main(String[] args) {
		ThreadDemo1 td = new ThreadDemo1();
		//ִ��callable��ʽ����ΪҪ���ܷ���ֵ����ҪFutureTaskʵ�����֧�֣����ڽ���������
		//FutureTask ��Future�ӿڵ�ʵ����
		FutureTask<Integer> result = new FutureTask<Integer>(td);
		new Thread(result).start();
		//�����߳������Ľ��
		
		try {
			Integer sum = result.get();
			System.out.println(sum);
			System.out.println("--------------------");
			//FutureTask�����ڱ����Ĳ������·���ΪInterger.MaxValue���������̵߳Ĵ�ӡ��û��ִ�У������ڵȴ����߳�ִ�����
			//�����̵߳�����������Ȼ�����㣬����Ч�ʸ�
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
	}

}

class ThreadDemo1 implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i=0;i<=100;i++){//Integer.MAX_VALUE
			System.out.println(i);
			sum = sum+i;
		}
		return sum;
	}
	
}

//class ThreadDemo implements Runnable{
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//	}
//}