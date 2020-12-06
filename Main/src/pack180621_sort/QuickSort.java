package pack180621_sort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ints = {24,35,0,72,88,44,51,90,12,68};
		Tools.printArray(ints);
		quickSort2(ints,0,ints.length-1);
		Tools.printArray(ints);
	}

	private static void quickSort2(int[] ints,int lo,int hi){
		if(ints.length<2 || hi<=lo)
			return;
		int i = lo;
		int j = hi;
		int key = ints[lo];
		while(i<j){
			while(ints[j]>=key && i<j)
				j--;
			while(ints[i]<=key && i<j)
				i++;
			if(j>i){
				int temp = ints[i];
				ints[i] = ints[j];
				ints[j] = temp;
			}
		}
		int temp = ints[j];
		ints[j] = ints[lo];
		ints[lo] = temp;
		quickSort2(ints, lo, i-1);
		quickSort2(ints, i+1, hi);
	}
	
	private static void quickSort3(int[] ints,int lo,int hi){
		if(ints.length<2 || lo>=hi)
			return;
		int i = lo;
		int j = hi;
		int key = ints[lo];
		while(i!=j){
			while(ints[j]>=key && i<j)
				j--;
			while(ints[i]<=key && i<j)
				i++;
			if(i<j){
				int temp = ints[i];
				ints[i] = ints[j];
				ints[j] = temp;
			}
		}
		int temp = ints[lo];
		ints[lo] = ints[i];
		ints[i] = temp;
		quickSort3(ints, lo, i-1);
		quickSort3(ints, i+1, hi);
	}
	
	private static void quickSort1(int[] ints,int lo,int hi){
		if(lo>=hi||ints.length<2)
			return;
		int key = ints[lo];
		int i = lo;
		int j = hi;
		while(i!=j){
			while(ints[j]>=key && i<j)
				j--;
			while(ints[i]<=key && i<j)
				i++;
			if(i<j){
				int temp = ints[i];
				ints[i] = ints[j];
				ints[j] = temp;
			}
		}
		int temp = ints[j];//交换hi和id的数据
		ints[j] = ints[lo];
		ints[lo] = temp;
		quickSort1(ints, lo, i-1);
		quickSort1(ints, i+1, hi);
	}
	private static void quickSort(int[] ints,int lo,int hi) {
		//进行安全性检查
	    if(lo>=hi||ints.length<2){
	        return;
	    }
		int key = ints[lo];
		int i = lo;
		int j = hi;
		while(i!=j){
			while(ints[j]>=key && i<j)
				j--;
			while(ints[i]<=key && i<j)
				i++;
			if(i<j){
				int temp = ints[i];
				ints[i] = ints[j];
				ints[j] = temp;
			}
		}
		int temp = ints[j];//交换hi和id的数据
		ints[j] = ints[lo];
		ints[lo] = temp;
		quickSort(ints, lo, j-1);
		quickSort(ints, j+1, hi);
	}

}
