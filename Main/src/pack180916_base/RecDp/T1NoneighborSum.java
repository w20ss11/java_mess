package pack180916_base.RecDp;

public class T1NoneighborSum {

	public static void main(String[] args) {
		int[] ints = new int[]{1,2,4,1,7,8,3};
		int res = rec(ints,ints.length-1);
		System.out.println(res);
		res = dp(ints);
		System.out.println(res);
	}

	private static int dp(int[] ints) {
		int[] res = new int[ints.length];
		res[0]=ints[0];
		res[1]=ints[1];
		for(int i=2;i<ints.length;i++)
			ints[i] = max(ints[i-1],ints[i-2]+ints[i]);
		return ints[ints.length-1];
	}

	private static int rec(int[] ints,int n) {
		if(n==0)
			return ints[0];
		if(n==1)
			return ints[0]>ints[1]?ints[0]:ints[1];
		return max(rec(ints, n-1),rec(ints, n-2)+ints[n]);
	}
	
	
	
	private static int max(int... args) {
		int res = args[0];
		for(int i=1;i<args.length;i++){
			if(res<args[i])
				res = args[i];
		}
		return res;
	}

}
