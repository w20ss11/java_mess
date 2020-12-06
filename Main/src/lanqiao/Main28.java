package lanqiao;

import java.util.Scanner;

public class Main28 {
/**
 * 问题描述
　　给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
　　例如：
　　A =	1 2
　　		3 4
　　A的2次幂	7 10
　　			15 22
输入格式
　　第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
　　接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
输出格式
　　输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开
样例输入
2 2
1 2
3 4
样例输出
7 10
15 22*/
	static int n;
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] ints = new int[n][n];
		int[][] ints_ori = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				ints[i][j] = scanner.nextInt();
				ints_ori[j][i] = ints[i][j];//为原矩阵的转置
			}
		if(m==0){
			for(int i=0;i<n;i++)//打印
				for(int j=0;j<n;j++){
					if(i==j){
						System.out.print(1+" ");
					}
					else if(j==n-1){
						System.out.print(0);
						System.out.println();
					}
					else
						System.out.print(0+" ");
				}
			return;
		}
		for(int t=0;t<m-1;t++){//m次幂
			ints = mul_matrix(ints,ints_ori);
		}
		for(int i=0;i<n;i++)//打印
			for(int j=0;j<n;j++){
				if(j==n-1){
					System.out.print(ints[i][j]);
					System.out.println();
				}
				else
					System.out.print(ints[i][j]+" ");
			}
	}

	private static int[][] mul_matrix(int[][] ints, int[][] ints_ori) {
		int[][] res = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				res[i][j] = row_mul_col(ints[i],ints_ori[j]);
			}
		}
		return res;
	}

	private static int row_mul_col(int[] is, int[] is2) {
		int res = 0;
		for(int k=0;k<n;k++)
			res = res + is[k]*is2[k];
		return res;
	}

}
