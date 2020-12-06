package pack180621_sort;

import java.util.Arrays;

public class Mess {

	public static void main(String[] args) {
		int[] ints = new int[]{3,6,4,8,1,7,0};
		//		select(ints);
		//		bubble(ints);
		//		insert1(ints);
		quickSort(ints, 0, ints.length-1);
		System.out.println(Arrays.toString(ints));
	}


	private static void quickSort(int[] ints,int lo,int hi){
		if(hi <= lo)
			return;
		int i = lo+1;
		int j = hi;
		int key = ints[lo];
		while(j>i){
			while(ints[j]>key && j>i)
				j--;
			while(ints[i]<key && j>i)
				i++;
			swap(ints, i, j);
		}
		swap(ints, i, lo);
		System.out.println(lo+" "+(i-1));
		quickSort(ints, lo, i-1);
		quickSort(ints, i+1, hi);
	}

	private static void insert1(int[] ints) {
		for(int i=1;i<ints.length;i++){
			int index = i-1;
			int k = ints[i];
			while(index>=0 && ints[index]>k){
				ints[index+1] = ints[index];
				index--;
			}
			ints[index+1] = k;
		}
	}

	private static void insert(int[] ints){
		for(int i=1;i<ints.length;i++){
			int key = ints[i];
			int index = i-1;
			while(index>=0 && ints[index]>key){
				ints[index+1] = ints[index];
				index--;
			}
			ints[index+1] = key;
		}
	}

	private static void select(int[] ints) {
		for(int i=0;i<ints.length-1;i++)
			for(int j=i+1;j<ints.length;j++)
				if(ints[i]>ints[j])
					swap(ints, i, j);
	}

	private static void bubble(int[] ints){
		for(int i=ints.length-1;i>0;i--)
			for(int j=0;j<i;j++)
				if(ints[j]>ints[j+1])
					swap(ints, j, j+1);
	}

	public static void swap(int[] ints,int i,int j){
		int temp = ints[i];
		ints[i] = ints[j];
		ints[j] = temp;
	}

}
