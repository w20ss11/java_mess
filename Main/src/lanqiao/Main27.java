package lanqiao;

import java.util.Scanner;

public class Main27 {
/**
 * ��������
��������һ������Ϊ��λ��ʱ��t��Ҫ���á�<H>:<M>:<S>���ĸ�ʽ����ʾ���ʱ�䡣<H>��ʾʱ�䣬<M>��ʾ���ӣ���<S>��ʾ�룬
���Ƕ���������û��ǰ���ġ�0�������磬��t=0����Ӧ����ǡ�0:0:0������t=3661���������1:1:1����
�����ʽ
��������ֻ��һ�У���һ������t��0<=t<=86399����
�����ʽ
�������ֻ��һ�У����ԡ�<H>:<M>:<S>���ĸ�ʽ����ʾ��ʱ�䣬���������š�
��������	0
�������	0:0:0
��������	5436
�������	1:30:36*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int[] res = new int[3];
		if(t>=3600){
			res[0] = t/3600;
			t = t%3600;
		}
		if(t>=60){
			res[1] = t/60;
			t = t%60;
		}
		res[2] = t;
		System.out.println(res[0]+":"+res[1]+":"+res[2]);
	}

}
