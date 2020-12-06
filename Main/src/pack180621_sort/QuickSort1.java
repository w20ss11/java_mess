package pack180621_sort;

import java.util.Arrays;
/**øÏ≈≈*/
public class QuickSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] ints = {2,5,9,3,6,1,7};
		 System.out.println(Arrays.toString(ints));;
		 quickSort(ints,0,ints.length-1);
		 System.out.println(Arrays.toString(ints));;
	}

	private static void quickSort(int[] ints,int lo, int hi) {
		if(ints.length<2 || hi<=lo)
			return;
		int key = ints[lo];
		int i = lo;
		int j = hi;
		while(j>i){
			while(ints[j]>=key && j>i)
				j--;
			while(ints[i]<=key && j>i)
				i++;
			if(j>i){
				int temp = ints[i];
				ints[i] = ints[j];
				ints[j] = temp;
			}
		}
		int temp = key;
		ints[lo] = ints[i];
		ints[i] = temp;
		quickSort(ints, i+1, hi);
		quickSort(ints, lo, i-1);
	}

}
