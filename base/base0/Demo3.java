class Demo3{
	public static void main(String[] args){
		int[] a=new int[40];
		a[0]=1;
		a[1]=1;
		for(int i=2;i<=39;i++)
			a[i]=a[i-1]+a[i-2];
		arrprint(a);
	}
	public static void arrprint(int[] arr1){
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+" ");
		System.out.println();
	}
}