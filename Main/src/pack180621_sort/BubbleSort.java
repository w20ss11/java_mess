package pack180621_sort;

class BubbleSort{
	public static void main(String[] args){
		int[] ints = {24,35,0,72,88,44,51,90,12,68};
		printArray(ints);
		ints = bubbleSort(ints);
		printArray(ints);
	}
	public static int[] bubbleSort(int[] ints){
		for(int i=0;i<ints.length-1;i++){
			for(int j=0;j<ints.length-1-i;j++){
				if(ints[j]>ints[j+1]){
					int temp = ints[j+1];
					ints[j+1] = ints[j];
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