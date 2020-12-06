package pack180621_sort;

class SelectionSort{
	public static void main(String[] args){
		int[] ints = {24,35,0,72,88,44,51,90,12,68};
		printArray(ints);
		ints = selectionSort1(ints);
		printArray(ints);
	}
	public static int[] selectionSort(int[] ints){
		for(int i=0;i<ints.length-1;i++){
			for(int j=i+1;j<ints.length;j++){
				if(ints[i]>ints[j]){
					int temp = ints[i];
					ints[i] = ints[j];
					ints[j] = temp;
				}
			}
		}
		return ints;
	}
	public static int[] selectionSort1(int[] ints){
		int len = ints.length;
		for(int i=0;i<len-1;i++){
			int min_id = i;
			for(int j=i+1;j<len;j++){
				if(ints[min_id]>ints[j]){
					min_id = j;
				}
			}
			if(min_id!=i){
				int temp = ints[i];
				ints[i] = ints[min_id];
				ints[min_id] = temp;
			}
		}
		return ints;
	}
	public static void printArray(int[] ints){
		for(int i=0;i<ints.length;i++){
			System.out.print(ints[i]+" ");
		}
		System.out.println();
	}
}