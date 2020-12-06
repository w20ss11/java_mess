package pack180630_aimAtOffer;

import java.util.Arrays;

public class T25reOrderArray {
/**
 * ��Ŀ����
����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò���
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] ints = new int[]{2,4,6,1,3,7};
		int[] ints = new int[]{1,2,3,4,5,6,7};
		reOrderArray(ints);
		System.out.println(Arrays.toString(ints));
	}

	public static void reOrderArray1(int [] array) {
		int lo = 0;
		int hi = array.length-1;
		while(hi!=lo){
			while(array[hi]%2==0 && hi>lo)
				hi--;
			while(array[lo]%2==1 && hi>lo)
				lo++;
			swap(array, lo, hi);
		}
	}
	public static void reOrderArray(int [] array) {
		for(int i=0;i<array.length-1;i++){
			if(array[i]%2==1)//iΪ����
				continue;
			for(int j=i+1;j<array.length;j++){
				if(array[j]%2==1){
					int t = array[j];
					for(int k=j;k>i;k--)
						array[k] = array[k-1];
					array[i] = t;
					break;
				}
			}
		}
	}
	public static void swap(int[] ints,int i,int j){
		int temp = ints[i];
		ints[i] = ints[j];
		ints[j] = temp;
	}
}
