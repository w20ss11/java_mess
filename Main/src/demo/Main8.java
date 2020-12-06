package demo;

public class Main8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ints = new int[100];
		f(6,ints,0);
	}

	private static void f(int i,int[] ints,int k) {
		if(i<=0){
			for(int n=0;n<k;n++){
				System.out.print(ints[n]+" ");
			}
			System.out.println();
			return;
		}
		for(int j=i;j>0;j--){
			if(k>0 && i>ints[k-1])continue;
			ints[k]=j;
			f(i-j, ints,k+1);
		}
	}

}
