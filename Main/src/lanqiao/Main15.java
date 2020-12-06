package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main15 {
/**
 * 问题描述
　　输入一个正整数n，输出n!的值。
　　其中n!=1*2*3*…*n。
算法描述
　　n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。
使用一个数组A来表示一个大整数a，A[0]表示a的个位，A[1]表示a的十位，依次类推。
　　将a乘以一个整数k变为将数组A的每一个元素都乘以k，请注意处理相应的进位。
　　首先将a设为1，然后乘2，乘3，当乘到n时，即得到了n!的值。
输入格式
　　输入包含一个正整数n，n<=1000。
输出格式
　　输出n!的准确值。*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		int n = new Scanner(System.in).nextInt();
		if(n==0){
			System.out.println("0");
			return;
		}else if(n==1){
			System.out.println("1");
			return;
		}
		int[] shu = new int[2568];
		shu[0] = 1;
		int up_int = 0;
		for(int i=2;i<=n;i++){
			for(int j=0;j<=2567;j++){
				int temp = shu[j]*i;
				temp = temp + up_int;
				shu[j] = temp%10;
				if(temp>=9){
					up_int = temp/10;
				}else {
					up_int = 0;
				}
			}
		}
		String str = Arrays.toString(shu).replace(", ", "");
		str = str.substring(1, str.length()-1);
		StringBuffer sb = new StringBuffer(str);
		String res = sb.reverse().toString();
		res = res.replaceAll("^(0+)", "");
 		System.out.println(res);
	}

}
