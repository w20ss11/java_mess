class Demo2{
	public static void main(String[] args){
		int a[]={20,12,25,74,33,46,32,67,93};
		arrprint(a);
		sort(a);
		arrprint(a);
	}
	public static int[] sort(int[] a){
		int i=a.length-1;
		for(int m=0;m<i-1;m++)
			for(int n=m+1;n<=i;n++)
				if(a[m]>a[n])
					swap(a,m,n);
				else
					continue;
		return a;
	}
	public static void swap(int[] arr,int a,int b){
		int t=arr[a];
		arr[a]=arr[b];
		arr[b]=t;
	}
	public static void arrprint(int[] arr1){
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+" ");
		System.out.println();
	}
}