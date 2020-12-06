package pack180621_sort;

import java.util.Arrays;

public class Demo1 {

	public static void main(String[] args) {
		int[] ints = {24,35,0,90,12,68};
		System.out.println(Arrays.toString(ints));
		quickSort(ints,0,ints.length-1);
		System.out.println(Arrays.toString(ints));
	}

	private static void quickSort(int[] ints,int lo,int hi) {
		if(lo>=hi)
			return;
		
		int id = lo;
		int temp;
		int i = lo;
		int j = hi;
		while(j>i){
			while(j>i && ints[j]>ints[id]){
				j--;
			}
			while(j>i && ints[i]<ints[id]){
				i++;
			}
			//交换
			temp = ints[i];
			ints[i] = ints[j];
			ints[j] = temp;
		}
		//交换id 切割两部分 继续quickSort
		temp = ints[id];
		ints[id] = ints[j];
		ints[j] = temp;
		quickSort(ints, lo, j-1);
		quickSort(ints, j+1, hi);
	}

}
