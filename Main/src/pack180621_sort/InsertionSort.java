package pack180621_sort;

class InsertionSort{
	public static void main(String[] args){
		int[] ints = {24,35,0,72,88,44,51,90,12,68};
		printArray(ints);
		ints = insertionSort(ints);
		printArray(ints);
	}
	public static int[] insertionSort(int[] ints){
		int len = ints.length;
		for(int i=1;i<len;i++){
			for(int j=0;j<i;j++){
				if(ints[j]>ints[i]){
					int temp = ints[i];
					ints[i] = ints[j];
					ints[j] = temp;
				}
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