package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main17 {
/**
 * ��������
��������һ��n*n�����̣���������һЩλ�ò��ܷŻʺ�
����Ҫ�������з���n���ڻʺ��n���׻ʺ�
ʹ����������ڻʺ󶼲���ͬһ�С�ͬһ�л�ͬһ���Խ����ϣ�����������׻ʺ󶼲���ͬһ�С�ͬһ�л�ͬһ���Խ����ϡ����ܹ��ж����ַŷ���nС�ڵ���8��
�����ʽ
��������ĵ�һ��Ϊһ������n����ʾ���̵Ĵ�С��������n�У�ÿ��n��0��1��������
���һ������Ϊ1����ʾ��Ӧ��λ�ÿ��ԷŻʺ����һ������Ϊ0����ʾ��Ӧ��λ�ò����ԷŻʺ�
�����ʽ
�������һ����������ʾ�ܹ��ж����ַŷ���
��������:4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
�������:2
��������
4
1 0 1 1
1 1 1 1
1 1 1 1
1 1 1 1
�������:0*/
	static int[][] ints;
	static int[][] ints_ori;
	static int count;
	static int n;
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		ints = new int[n][n];
		ints_ori = new int[n][n];
		for(int i = 0;i<n;i++)
			for(int j = 0;j<n;j++){
				ints[i][j] = scanner.nextInt();
				ints_ori[i][j] = ints[i][j];
			}
		count = 0;
		put(0,2,0);
		System.out.println(count);
	}
	public static void put(int row,int num,int start_id){
		for(int i=start_id;i<n;i++){
			if(ints[row][i]==1 && check(row,i,num)){//���row�е�i��λ���ܷ����num
				//System.out.println("check("+row+","+i+","+num+"): "+check(row,i,num));
				ints[row][i]=num;
				if(row<n-1){//��ǰ�з���num��ɺ󣬵�ǰ�в������һ��ʱ
					put(++row, num, 0);
					return;
				}else if(row==n-1 && num==2){//��ǰ�з���num��ɺ󣬵�ǰ�������һ��ʱ,�����õ�����Ϊ2ʱ�����´ӵ�һ�п�ʼ����3
					put(0, 3, 0);
					return;
				}else{//row==n-1 && num==3
					System.out.println(Arrays.deepToString(ints));
					count++;
					for(int j=0;j<n;j++)
						if(ints[0][j]==2){
							if(j==n-1)
								return;
							else{
								resetInts();
								put(0, 2,j+1);
								return;
							}
						}
				}
			}else{
				continue;
			}
		}
		//ִ�е��ˣ���ʾ��row�ж������Է���num�����ݵ�row-1�У���ȡ�к�
		if(row==0){
			return;
		}
		for(int j=0;j<n;j++)
			if(ints[row-1][j]==num){
				ints[row-1][j]=1;
				put(row-1, num,j+1);
			}
	}
	public static boolean check(int row, int col, int num) {
		for(int i=0;i<row;i++){
			if(ints[i][col]==num)//���ͬһ���Ϸ�������б�Ϸ� TODO����к�
				return false;
			if(col+(row-i)<n && ints[i][col+(row-i)]==num)
				return false;
			if(col-(row-i)>=0 && ints[i][col-(row-i)]==num)
				return false;
		}
		return true;
	}
	public static void resetInts(){
		for(int i = 0;i<n;i++)
			for(int j = 0;j<n;j++)
				ints[i][j] = ints_ori[i][j];
	}

}
