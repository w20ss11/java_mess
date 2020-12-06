package demo;

public class Main9 {

	/**
	 * @param args
	 */
	static int count = 0;
	public static void main(String[] args) {
		int sum = 6;
		int[] a = {3,2,4,3,1};
		int[] res = new int[5];
//		f(sum,a,0,0,res);
		f1(sum,a,0,0);
		System.out.println(count);
	}

	//a的第k位开始，是否加入
	private static void f1(int sum, int[] a, int k,int cur_sum) {
		if(cur_sum>sum)return;
		if(cur_sum==sum){
			count=count+1;
			return;
		}
		if(k>=a.length)return;
		f1(sum, a, k+1, cur_sum);
		cur_sum = cur_sum + a[k];
		f1(sum, a, k+1, cur_sum);
		
	}
	
	private static void f(int sum, int[] a, int k, int cur_sum,int[] res) {
		if(cur_sum==sum){
			for(int j=0;j<k;j++){
				System.out.print(res[j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<a.length;i++){
			if(a[i]<sum && a[i]!=-1){
				res[k]=a[i];
				a[i] = -1;
				cur_sum = cur_sum + a[i];
				f(sum, a, k+1, cur_sum, res);
			}
		}
		return;
	}

}
