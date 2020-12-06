package pack180621_sort;

public class ShellSort {

	public static void main(String[] args) {
		int[] ints = {24,35,0,72,88,44,51,90,12,68};
		Tools.printArray(ints);
//		sort1(ints);
		shellSort2(ints);
		Tools.printArray(ints);
	}
	
	private static void shellSort2(int[] ints){
		int gap = ints.length/2;
		while(gap>0){
			for(int i=gap;i<ints.length;i++){
				for(int j=i-gap;j>=0;j=j-gap){
					if(ints[j]>ints[i]){
						int temp = ints[i];
						ints[i] = ints[j];
						ints[j] = temp;
					}
				}
			}
			gap = gap/2;
		}
	}
	
	private static void shellSort1(int[] ints) {
		int gap = ints.length/2;
		while(gap>0){
			for(int i=gap;i<ints.length;i++){
				for(int j=i-gap;j>=0;j=j-gap){
					if(ints[j]>ints[i]){
						int temp = ints[i];
						ints[i] = ints[j];
						ints[j] = temp;
					}
				}
			}
			gap = gap/2;
		}
		
	}
	private static void shellSort(int[] ints) {
		int gap = ints.length/2;
		while(gap>0){
			for(int i = gap;i<ints.length;i++){
				for(int j = i-gap;j>=0;j-=gap){
					if(ints[j]>ints[i]){
						int temp = ints[i];
						ints[i] = ints[j];
						ints[j] = temp;
					}
				}
			}
			gap = gap /2;
		}
	}

	
	public static void sort1(int []arr){
	    //增量gap，并逐步缩小增量
	    for(int gap=arr.length/2;gap>0;gap/=2){
	        //从第gap个元素，逐个对其所在组进行直接插入排序操作
	        for(int i=gap;i<arr.length;i++){
	            int j = i;
	            int temp = arr[j];
	            if(arr[j]<arr[j-gap]){
	                while(j-gap>=0 && temp<arr[j-gap]){
	                    //移动法
	                    arr[j] = arr[j-gap];
	                    j-=gap;
	                }
	                arr[j] = temp;
	            }
	        }
	    }
	}
}
