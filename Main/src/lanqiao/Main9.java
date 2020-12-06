package lanqiao;

import java.util.Scanner;

public class Main9 {
/**
 * 问题描述
杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。
它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。
下面给出了杨辉三角形的前4行：
   1
  1 1
 1 2 1
1 3 3 1
给出n，输出它的前n行。
输入格式:输入包含一个数n。
输出格式:输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分隔。
请不要在前面输出多余的空格。
样例输入
4
样例输出
1
1 1
1 2 1
1 3 3 1*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		int n = new Scanner(System.in).nextInt();
		if(n==1){
			System.out.println(1);
			return;}
		else if(n==2){
			System.out.println(1);
			System.out.println(1+" "+1);
			return;
		}
		System.out.println(1);
		System.out.println(1+" "+1);
		int[][] ints = new int[n][n];
		ints[0][0] = 1;
		ints[1][0] = 1;
		ints[1][1] = 1;
		for(int i=2;i<=n-1;i++){
			ints[i][0] = 1;
			System.out.print(1+" ");
			for(int j=1;j<=i;j++){
				ints[i][j] = ints[i-1][j-1] + ints[i-1][j];
				System.out.print(ints[i][j]+" ");
			}
			System.out.println();
		}
	}
}
