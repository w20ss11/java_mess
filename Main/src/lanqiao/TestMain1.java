package lanqiao;

import java.util.Scanner;

public class TestMain1 {
/**
 * 问题描述
　　小明先把硬币摆成了一个 n 行 m 列的矩阵。
　　随后，小明对每一个硬币分别进行一次 Q 操作。
　　对第x行第y列的硬币进行 Q 操作的定义：将所有第 i*x 行，第 j*y 列的硬币进行翻转。
　　其中i和j为任意使操作可行的正整数，行号和列号都是从1开始。
　　当小明对所有硬币都进行了一次 Q 操作后，他发现了一个奇迹——所有硬币均为正面朝上。
　　小明想知道最开始有多少枚硬币是反面朝上的。于是，他向他的好朋友小M寻求帮助。
　　聪明的小M告诉小明，只需要对所有硬币再进行一次Q操作，即可恢复到最开始的状态。然而小明很懒，不愿意照做。于是小明希望你给出他更好的方法。帮他计算出答案。
输入格式
　　输入数据包含一行，两个正整数 n m，含义见题目描述。
输出格式
　　输出一个正整数，表示最开始有多少枚硬币是反面朝上的。
样例输入	2 3
样例输出	1*/
	static int[][] ints;
	public static void main(String[] args) {
		//0为正面向上 1为向下
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ints = new int[n][m];
		for(int x=0;x<n;x++){
			for(int y=0;y<m;y++){
				q_oper(x,y);
			}
		}
		//统计ints中有多少个1
		int count = 0;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(ints[i][j]==1)
					count++;
		System.out.println(count);
	}
	private static void q_oper(int x, int y) {
		for(int i=1;i*(x+1)<ints.length;i++){
			for(int j=1;j*(y+1)<ints[0].length;j++){
				int ix = i*(x+1)-1;
				int iy = j*(y+1)-1;
				ints[ix][iy] = (ints[ix][iy]+1)%2;
			}
		}
	}

}
