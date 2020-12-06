import java.util.Scanner;
import java.util.Arrays;
public class Main{
	public static void main(String[] args){
		Scanner sca=new Scanner(System.in);
		String line=sca.nextLine();
		int n=Integer.valueOf(line);
		int[][] m=new int[n][n];
		for(int i=0;i<n;i++){
			String str=sca.nextLine();
			String[] strs=str.split(" ");
			for(int j=0;j<=i;j++){
				m[i][j]=Integer.valueOf(strs[j]);
			}
			//System.out.println(Arrays.deepToString(m));
		}
		int[] last=resFun(m,n-1);
		Arrays.sort(last);
		System.out.println(last[n-1]);
	}
	//int[][] m:the all input er wei array哈哈
	//r:count di ji hang;start from 0
	public static int[] resFun(int[][] m,int r){
		int[] resRow=new int[r+1];
		if(r==0)
			resRow[0]=m[0][0];
		else
			resRow=plusRow(resFun(m,r-1),m[r]);
		return resRow;
	}
	//res: res[n-1]
	//mRow:m[n]
	public static int[] plusRow(int[] res,int mRow[]){
		int k=res.length;
		int[] temp=new int[k+1];
		temp[0]=mRow[0]+res[0];
		temp[k]=mRow[k]+res[k-1];
		for(int x=1;x<k;x++){
			int i=res[x]+mRow[x];
			int j=res[x-1]+mRow[x];
			temp[x]=i>j?i:j;
		}
		//System.out.println("res:"+Arrays.toString(res));
		//System.out.println("mRow:"+Arrays.toString(mRow));
		//System.out.println("temp:"+Arrays.toString(temp));
		return temp;
	}
}