package lanqiao;

import java.util.Scanner;

public class TestMain1 {
/**
 * ��������
����С���Ȱ�Ӳ�Ұڳ���һ�� n �� m �еľ���
�������С����ÿһ��Ӳ�ҷֱ����һ�� Q ������
�����Ե�x�е�y�е�Ӳ�ҽ��� Q �����Ķ��壺�����е� i*x �У��� j*y �е�Ӳ�ҽ��з�ת��
��������i��jΪ����ʹ�������е����������кź��кŶ��Ǵ�1��ʼ��
������С��������Ӳ�Ҷ�������һ�� Q ��������������һ���漣��������Ӳ�Ҿ�Ϊ���泯�ϡ�
����С����֪���ʼ�ж���öӲ���Ƿ��泯�ϵġ����ǣ��������ĺ�����СMѰ�������
����������СM����С����ֻ��Ҫ������Ӳ���ٽ���һ��Q���������ɻָ����ʼ��״̬��Ȼ��С����������Ը������������С��ϣ������������õķ���������������𰸡�
�����ʽ
�����������ݰ���һ�У����������� n m���������Ŀ������
�����ʽ
�������һ������������ʾ�ʼ�ж���öӲ���Ƿ��泯�ϵġ�
��������	2 3
�������	1*/
	static int[][] ints;
	public static void main(String[] args) {
		//0Ϊ�������� 1Ϊ����
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
		//ͳ��ints���ж��ٸ�1
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
