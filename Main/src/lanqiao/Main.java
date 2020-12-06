package lanqiao;

import java.util.Scanner;

public class Main {
/**
 * 问题描述
Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。

当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。

输入格式
输入包含一个整数n。
输出格式
输出一行，包含一个整数，表示Fn除以10007的余数。*/
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
