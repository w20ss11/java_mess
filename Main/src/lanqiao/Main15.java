package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main15 {
/**
 * ��������
��������һ��������n�����n!��ֵ��
��������n!=1*2*3*��*n��
�㷨����
����n!���ܴܺ󣬶�������ܱ�ʾ��������Χ���ޣ���Ҫʹ�ø߾��ȼ���ķ�����
ʹ��һ������A����ʾһ��������a��A[0]��ʾa�ĸ�λ��A[1]��ʾa��ʮλ���������ơ�
������a����һ������k��Ϊ������A��ÿһ��Ԫ�ض�����k����ע�⴦����Ӧ�Ľ�λ��
�������Ƚ�a��Ϊ1��Ȼ���2����3�����˵�nʱ�����õ���n!��ֵ��
�����ʽ
�����������һ��������n��n<=1000��
�����ʽ
�������n!��׼ȷֵ��*/
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
