package pack180104_mess;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] ints = new int[2*n];
		int[] count = new int[k];
		for(int i=0;i<2*n;i++){
			ints[i] = scanner.nextInt();
		}
		int res = digui(ints, 0, 0, count);
		System.out.println(res);
	}

	public static boolean check(int[] count,int st,int en){
		for(int i = st;i<en;i++)
			if(count[i]==1)
				return false;//���ܲ���
		return true;//���Բ���
	}
	public static int digui(int[] ints,int id,int res,int[] count){//��id��
		if(id>ints.length/2)
			return res;
		digui(ints, id+2,res,count);//��ѡ��id��
		if(check(count, ints[id], ints[id+1])){//�����ѡ��
			res+=1;
			count = placeOne(count,ints[id], ints[id+1]);
			return digui(ints, id+2,res,count);//��ѡ��ѡ�ϵ�id��
		}
		return digui(ints, id+2,res,count);
	}

	private static int[] placeOne(int[] count, int st,int en) {
		if(en>st){
			for(int i=st;i<en;i++){
				count[i] = 1;
			}
			return count;
		}else{
			count = placeOne(count, 0,st+1);
			count = placeOne(count, en+1,count.length-1);
			return count;
		}
	}
}
