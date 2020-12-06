package demo;

public class Main11 {

	/**
	 * @param args
	 */
	static int count=0;
	public static void main(String[] args) {
		int[][] ints = new int[7][7];
		ints[3][3]=1;
		f(ints,3,3,3,3,true);
		System.out.println(count);
		System.out.println(count/4);
	}

	private static void f(int[][] ints, int i, int j,int m,int n,boolean is_fir) {
		// TODO Auto-generated method stub
		//判断
		if(i==m && j==n && !is_fir)//交叉
			return;
		if(i==0 || i==6 || j==0 || j==6){
			count++;
			return;
		}
		//上
		if(ints[i-1][j]!=1)
		{
			ints[i-1][j]=1;
			ints[m+1][n]=1;
			f(ints, i-1, j, m+1, n,false);
			//回溯
			ints[i-1][j]=0;
			ints[m+1][n]=0;}
		//下
		if(ints[i+1][j]!=1)
		{
			ints[i+1][j]=1;
			ints[m-1][n]=1;
			f(ints, i+1, j, m-1, n,false);
			//回溯
			ints[i+1][j]=0;
			ints[m-1][n]=0;}
		//左
		if(ints[i][j-1]!=1)
		{
			ints[i][j-1]=1;
			ints[m][n+1]=1;
			f(ints, i, j-1, m, n+1,false);
			//回溯
			ints[i][j-1]=0;
			ints[m][n+1]=0;}
		//右
		if(ints[i][j+1]!=1)
		{
			ints[i][j+1]=1;
			ints[m][n-1]=1;
			f(ints, i, j+1, m, n-1,false);
			//回溯
			ints[i][j+1]=0;
			ints[m][n-1]=0;}
		
	}

}
