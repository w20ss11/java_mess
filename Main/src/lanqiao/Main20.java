package lanqiao;

import java.util.Scanner;

public class Main20 {
/**
 * ��������
��������ȡ�������ؾ���ı�ȡ��������ǰ������������ȡ���Ѿ�ȡ��������ת90�ȡ�һ��ʼλ�ھ������Ͻǣ��������¡�
�����ʽ
���������һ��������������200��������m, n����ʾ������к��С�������m��ÿ��n����������ʾ�������
�����ʽ
�������ֻ��һ�У���mn������Ϊ����������ȡ���õ��Ľ������֮����һ���ո�ָ�����ĩ��Ҫ�ж���Ŀո�
�������� 3 3
1 2 3
4 5 6
7 8 9
������� 1 4 7 8 9 6 3 2 5
�������� 3 2
1 2
3 4
5 6
������� 1 3 5 6 4 2*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] ints = new int[m][n];
		for(int i = 0;i<m;i++)
			for(int j = 0;j<n;j++)
				ints[i][j] = scanner.nextInt();
		int i=0, j=0;
		int w1=0, w2=m-1, w3=n-1, w4=0;
		int step = 0;
		String str = "";
		while(w2>=w4 && w3>=w1){
			if(step==0){//����
				for(int t=i;t<=w2;t++){
					//System.out.println(ints[t][w1]);
					str = str+ints[t][w1]+" ";
					i = t;
				}
				j = w1;
				w1++;
				step++;
			}else if(step==1){
				for(int t=j+1;t<=w3;t++){
					//System.out.println(ints[w2][t]);
					str = str+ints[w2][t]+" ";
					j = t;
				}
				i = w2;
				w2--;
				step++;
			}else if(step==2){
				for(int t=i-1;t>=w4;t--){
					//System.out.println(ints[t][w3]);
					str = str+ints[t][w3]+" ";
					i = t;
				}
				j = w3;
				w3--;
				step++;
			}else if(step==3){
				for(int t=j-1;t>=w1+1;t--){
					//System.out.println(ints[w4][t]);
					str = str+ints[w4][t]+" ";
					j = t;
				}
				i = w4;
				w4++;
				step=0;
			}
		}
		System.out.println(str.substring(0, str.length()-1));
	}
}
