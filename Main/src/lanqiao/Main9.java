package lanqiao;

import java.util.Scanner;

public class Main9 {
/**
 * ��������
����������ֳ�Pascal�����Σ����ĵ�i+1����(a+b)i��չ��ʽ��ϵ����
����һ����Ҫ�����ǣ��������е�ÿ�����ֵ����������ϵ�������ӡ�
�����������������ε�ǰ4�У�
   1
  1 1
 1 2 1
1 3 3 1
����n���������ǰn�С�
�����ʽ:�������һ����n��
�����ʽ:�����������ε�ǰn�С�ÿһ�д���һ�еĵ�һ������ʼ����������м�ʹ��һ���ո�ָ���
�벻Ҫ��ǰ���������Ŀո�
��������
4
�������
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
