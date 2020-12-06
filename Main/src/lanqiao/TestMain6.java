package lanqiao;

public class TestMain6 {

	static int count = 0;
	public static void main(String[] args) {
		int sum = 6;
		int[] a = {3,2,4,3,1};
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

}
