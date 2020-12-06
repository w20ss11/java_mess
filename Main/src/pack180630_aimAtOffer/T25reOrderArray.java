package pack180630_aimAtOffer;

import java.util.Arrays;

public class T25reOrderArray {
/**
 * 题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
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
			if(array[i]%2==1)//i为奇数
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
