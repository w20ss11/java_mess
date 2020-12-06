package pack180916_base.RecDp;

public class T2SolidSumFromArr {

	public static void main(String[] args) {
		int[] ints = new int[]{3,34,4,12,5,2};
		boolean res = rec(ints,5,11);//13²»ĞĞ
		System.out.println(res);
		res = dp(ints,13);
		System.out.println(res);
	}

	private static boolean dp(int[] ints, int sum) {
		boolean[][] res = new boolean[ints.length][sum+1];
		for(int j=0;j<=sum;j++){
			res[0][j] = (ints[0]==j);
		}
		for(int i=0;i<ints.length;i++){
			res[i][0]=true;
		}
		for(int i=1;i<ints.length;i++){
			for(int j=1;j<=sum;j++){
				if(j-ints[i]>=0)
					res[i][j] = res[i-1][j] || res[i-1][j-ints[i]];
				else
					res[i][j] = res[i-1][j];
			}
		}
		return res[ints.length-1][sum];
	}

	private static boolean rec(int[] ints, int index, int sum) {
		if(sum==0)
			return true;
		if(index==0)
			return ints[0]==sum;
		if(ints[index]>sum)
			return rec(ints, index-1, sum);
		return rec(ints, index-1, sum-ints[index]) || rec(ints, index-1, sum);
	}

}
