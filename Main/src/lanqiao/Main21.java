package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main21 {
/**
 * ��������
������n��2��n��20����оƬ���к��л�����֪��оƬ�Ȼ�оƬ�ࡣ
����ÿ��оƬ����������������оƬ���ú�оƬ��������оƬʱ������ȷ����������оƬ�Ǻû��ǻ������û�оƬ��������оƬʱ������������û��ǻ��Ĳ��Խ�������˽���뱻����оƬʵ�ʵĺû��޹أ���
������������оƬ�Ĳ��Խ��������ЩоƬ�Ǻ�оƬ��
�����ʽ
�����������ݵ�һ��Ϊһ������n����ʾоƬ������
�����ڶ��е���n+1��Ϊn*n��һ�ű�ÿ��n�����ݡ����е�ÿ������Ϊ0��1������n���еĵ�i�е�j�У�1��i, j��n�������ݱ�ʾ�õ�i��оƬ���Ե�j��оƬʱ�õ��Ĳ��Խ����1��ʾ�ã�0��ʾ����i=jʱһ��Ϊ1��������ʾ��оƬ�Ա���Ĳ��Խ����
оƬ���ܶԱ�����в��ԣ���
�����ʽ
��������С�����˳��������к�оƬ�ı��
��������
3
1 0 1
0 1 0
1 0 1
�������
1 3*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] ints = new int[n][n];
		String res = "";
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				ints[i][j] = scanner.nextInt();
			}
		}
		int half = n/2;
		int[] col_sum = new int[n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				col_sum[j] = col_sum[j] + ints[i][j];
			}
		}
//		System.out.println(Arrays.toString(col_sum));
//		System.out.println("half:"+half);
		for(int i=0;i<n;i++){
			if(col_sum[i]>half)
				res = res+(i+1)+" ";
		}
		System.out.println(res.substring(0, res.length()-1));
	}

}
