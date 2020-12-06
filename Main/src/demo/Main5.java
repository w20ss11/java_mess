package demo;

public class Main5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = select(10,3);
		System.out.println(sum);
	}

	private static int select(int m, int n) {
		// TODO Auto-generated method stub
		if(m<n)return 0;
		if(m==n)return 1;
		if(n==0)return 1;
		return select(m-1, n)+select(m-1, n-1);
	}

}
