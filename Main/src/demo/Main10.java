package demo;

public class Main10 {

	/**
	 * @param args
	 */
	static int count=0;
	public static void main(String[] args) {
		int[][] sum1 = new int[50][2];
		int[][] sum2 = new int[50][2];
		int[][] ints1 = new int[50][2];
		int[][] ints2 = new int[50][2];
		f(sum1,sum2,ints1,ints2,1);
		System.out.println(count);
		System.out.println(count/4);
		
	}
	//ints1：两个反向每一步具体怎么走  ints：每一步走后总坐标
	private static void f(int[][] sum1,int[][] sum2, int[][] ints1, int[][] ints2, int k) {
		// TODO Auto-generated method stub
		if(sum1[k-1][0]==3 || sum1[k-1][0]==-3 ||
				sum1[k-1][1]==3 || sum1[k-1][1]==-3 ||
				sum2[k-1][0]==3 || sum2[k-1][0]==-3 ||
				sum2[k-1][1]==3 || sum2[k-1][1]==-3){
			count++;
			return;
		}
		//////////////////////////////////
		ints1[k][0]=1;//向上走
		ints2[k][0]=-1;
		sum1[k][0] = sum1[k-1][0]+1;
		sum1[k][1] = sum1[k-1][1];
		sum2[k][0] = sum2[k-1][0]-1;
		sum2[k][1] = sum2[k-1][1];
		if(judge(ints1,ints2,sum1,sum2,k)){//判断交叉和返回
			return;
		}else
			f(sum1, sum2,ints1, ints2, k+1);
		ints1[k][0]=0;//回溯
		ints2[k][0]=0;
		//////////////////////////////////
		ints1[k][0]=-1;//向下走
		ints2[k][0]=1;
		sum1[k][0] = sum1[k-1][0]-1;
		sum1[k][1] = sum1[k-1][1];
		sum2[k][0] = sum2[k-1][0]+1;
		sum2[k][1] = sum2[k-1][1];
		if(judge(ints1,ints2,sum1,sum2,k)){//判断交叉和返回
			return;
		}else
			f(sum1, sum2,ints1, ints2, k+1);
		ints1[k][0]=0;//回溯
		ints2[k][0]=0;
		//////////////////////////////////
		ints1[k][1]=1;//向左走
		ints2[k][1]=-1;
		sum1[k][0] = sum1[k-1][0];
		sum1[k][1] = sum1[k-1][1]+1;
		sum2[k][0] = sum2[k-1][0];
		sum2[k][1] = sum2[k-1][1]-1;
		if(judge(ints1,ints2,sum1,sum2,k)){//判断交叉和返回
			return;
		}else
			f(sum1, sum2,ints1, ints2, k+1);
		ints1[k][0]=0;//回溯
		ints2[k][0]=0;
		//////////////////////////////////
		ints1[k][1]=-1;//向右走
		ints2[k][1]=1;
		sum1[k][0] = sum1[k-1][0];
		sum1[k][1] = sum1[k-1][1]-1;
		sum2[k][0] = sum2[k-1][0];
		sum2[k][1] = sum2[k-1][1]+1;
		if(judge(ints1,ints2,sum1,sum2,k)){//判断交叉和返回
			return;
		}else
			f(sum1, sum2,ints1, ints2, k+1);
		ints1[k][0]=0;//回溯
		ints2[k][0]=0;
	}

	private static boolean judge(int[][] ints1, int[][] ints2, int[][] sum1, int[][] sum2, int k) {
		// TODO Auto-generated method stub
		for(int i=1;i<k;i++){
			for(int j=0;j<k-1;j++){
				if(sum1[i][0]==sum1[j][0] && sum1[i][1]==sum1[j][1])//判断返回
					return true;
			}
			if(sum1[i][0]==sum2[i][0] && sum1[i][1]==sum2[i][1])//判断交叉
				return true;
		}
		return false;
	}

}
