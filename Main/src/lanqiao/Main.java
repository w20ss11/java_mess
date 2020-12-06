package lanqiao;

import java.util.Scanner;

public class Main {
/**
 * ��������
Fibonacci���еĵ��ƹ�ʽΪ��Fn=Fn-1+Fn-2������F1=F2=1��

��n�Ƚϴ�ʱ��FnҲ�ǳ�������������֪����Fn����10007�������Ƕ��١�

�����ʽ
�������һ������n��
�����ʽ
���һ�У�����һ����������ʾFn����10007��������*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
        int n= input.nextInt();
        int res = fibonacci(n);
        res = fibonacci1(n);
        System.out.println(res%10007);
	}

	private static int fibonacci1(int n) {
		if(n<=2)
			return 1;
		int f1 = 1;
		int f2 = 1;
		for(int i=0;i<n-2;i++){
			int temp = f1%10007 + f2%10007;
			f1 = f2;
			f2 = temp;
		}
		return f2;
	}

	private static int fibonacci(int n) {
		if(n<=2)
			return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}

}
