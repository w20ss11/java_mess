package pack180621_sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] ints = {24,35,0,72,88,44,51,90,12,68};
		Tools.printArray(ints);
		sort1(ints,0,ints.length-1);
		Tools.printArray(ints);
	}
	
	public static int[] sort1(int[] ints,int lo,int hi){
		int mid = (lo+hi)/2;
		if(lo<hi){
			sort(ints, lo, mid);
			sort(ints, mid+1, hi);
			merge1(ints, lo, mid, hi);
		}
		return ints;
	}
	
	private static void merge1(int[] ints, int lo, int mid, int hi) {
		int i = lo;
		int j = mid+1;
		int count = 0;
		int[] temp = new int[hi-lo+1];
		while(i<=mid && j<=hi){
			if(ints[i]<ints[j])
				temp[count++] = ints[i++];
			else
				temp[count++] = ints[j++];
		}
		while(i<=mid)
			temp[count++] = ints[i++];
		while(j<=hi)
			temp[count++] = ints[j++];
		for(int k=0;k<temp.length;k++)
			ints[lo+k] = temp[k];
	}

	public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }
     
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组 
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }

}
