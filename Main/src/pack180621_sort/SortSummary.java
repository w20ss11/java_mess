package pack180621_sort;

public class SortSummary {

	public static void main(String[] args) {
		int[] ints = {24,35,0,72,88,44,51,90,12,68};
		Tools.printArray(ints);
		sort(ints,0,ints.length-1);
		Tools.printArray(ints);
	}

	private static int[] sort(int[] ints, int lo, int hi) {
		if(hi==lo){
			return ints;
		}
		if(lo<hi){
			int mid = (lo+hi)/2;
			sort(ints, lo, mid);
			sort(ints, mid+1, hi);
			merge(ints,lo,mid,hi);
		}
		return ints;
	}

	private static void merge(int[] ints,int lo,int mid,int hi) {
		int[] temp = new int[hi-lo+1];
		int i = lo;
		int j = mid+1;
		int id = 0;
		while(i<=mid && j<=hi){
			if(ints[i]<ints[j]){
				temp[id++] = ints[i++];
			}else{
				temp[id++] = ints[j++];
			}
		}
		while(i<=mid){
			temp[id++] = ints[i++];
		}
		while(j<=hi){
			temp[id++] = ints[j++];
		}
		for(int m=0;m<temp.length;m++){
			ints[lo+m] = temp[m];
		}
	}

}
