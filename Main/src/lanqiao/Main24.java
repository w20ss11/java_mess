package lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main24 {
/**
 * 问题描述
　　求出区间[a,b]中所有整数的质因数分解。
输入格式
　　输入两个整数a，b。
输出格式
　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
样例输入
3 10
样例输出
3=3
4=2*2
5=5
6=2*3
7=7
8=2*2*2
9=3*3
10=2*5
提示
　　先筛出所有素数，然后再分解。
数据规模和约定
　　2<=a<=b<=10000*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		for(int i=m;i<=n;i++){
			System.out.print(i+"=");
			getPrime(i);
			System.out.println();
		}
	}

	private static void getPrime(int num) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int j=2;j<=num;j++){
			if(num%j==0){
				list.add(j);
				num = num/j;
				if(num!=1){
					j = 1;
					continue;
				}
				else
					break;
			}
		}
//		System.out.print("list:"+list.toString());
		for(int k=0;k<list.size();k++){
			if(k<list.size()-1)
				System.out.print(list.get(k)+"*");
			else
				System.out.print(list.get(k));
				
		}
	}

}
