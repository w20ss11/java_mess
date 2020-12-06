package lanqiao;

import java.util.Scanner;

public class Main28 {
/**
 * ��������
��������һ��N�׾���A�����A��M���ݣ�M�ǷǸ�������
�������磺
����A =	1 2
����		3 4
����A��2����	7 10
����			15 22
�����ʽ
������һ����һ��������N��M��1<=N<=30, 0<=M<=5������ʾ����A�Ľ�����Ҫ�������
����������N�У�ÿ��N������ֵ������10�ķǸ���������������A��ֵ
�����ʽ
���������N�У�ÿ��N����������ʾA��M��������Ӧ�ľ������ڵ���֮����һ���ո����
��������
2 2
1 2
3 4
�������
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
				ints_ori[j][i] = ints[i][j];//Ϊԭ�����ת��
			}
		if(m==0){
			for(int i=0;i<n;i++)//��ӡ
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
		for(int t=0;t<m-1;t++){//m����
			ints = mul_matrix(ints,ints_ori);
		}
		for(int i=0;i<n;i++)//��ӡ
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
