package demo;

import java.util.ArrayList;
import java.util.Arrays;

public class Main15 {

	/**
	 * @param args
	 */
	static int count = 0;
	public static void main(String[] args) {
		
		int[] ints = new int[]{1,2,3,4,5,6,7,8,9};
		String chengshu1 = "";
		String chengshu2 = "";
		split(ints,0,chengshu1,chengshu2);
		
//		char[] chs = new char[]{'A','B','C'};
//		arrange(chs, 0);
//		String s = "abc";
//		System.out.println(s.substring(0,s.length()));
	}

	private static void split(int[] ints, int d, String chengxu1, String chengxu2) {
		//�ݹ��в���ʹ����һ�������ģ��������дε��ܽ��
		if(d==ints.length){
			if(chengxu1.length()==0 || chengxu2.length()==0)
				return;
			if(judeg(chengxu1,chengxu2))
				count++;
			return;
		}
		//d�������1
		chengxu1 = chengxu1+ints[d];
		split(ints, d+1, chengxu1, chengxu2);
		//����    ��d�������2
		chengxu1 = chengxu1.substring(0,chengxu1.length()-1);
		chengxu2 = chengxu2+ints[d];
		split(ints, d+1, chengxu1, chengxu2);
	}

	private static boolean judeg(String chengxu1, String chengxu2) {
		
		return false;
	}

	private static void arrange(char[] chs, int d) {
		if(d==chs.length-1){
			System.out.println(Arrays.toString(chs));
			return;
		}
		for(int i=d;i<chs.length;i++){
			char temp = chs[d];
			chs[d] = chs[i];
			chs[i] = temp;
			arrange(chs, d+1);
			//����
			temp = chs[d];
			chs[d] = chs[i];
			chs[i] = temp;
		}
	}

}
