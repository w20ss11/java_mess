package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main17 {
/**
 * 问题描述
　　给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。
现在要向棋盘中放入n个黑皇后和n个白皇后，
使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
输入格式
　　输入的第一行为一个整数n，表示棋盘的大小。接下来n行，每行n个0或1的整数，
如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放皇后。
输出格式
　　输出一个整数，表示总共有多少种放法。
样例输入:4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
样例输出:2
样例输入
4
1 0 1 1
1 1 1 1
1 1 1 1
1 1 1 1
样例输出:0*/
	static int[][] ints;
	static int[][] ints_ori;
	static int count;
	static int n;
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		ints = new int[n][n];
		ints_ori = new int[n][n];
		for(int i = 0;i<n;i++)
			for(int j = 0;j<n;j++){
				ints[i][j] = scanner.nextInt();
				ints_ori[i][j] = ints[i][j];
			}
		count = 0;
		put(0,2,0);
		System.out.println(count);
	}
	public static void put(int row,int num,int start_id){
		for(int i=start_id;i<n;i++){
			if(ints[row][i]==1 && check(row,i,num)){//检查row行第i个位置能否放置num
				//System.out.println("check("+row+","+i+","+num+"): "+check(row,i,num));
				ints[row][i]=num;
				if(row<n-1){//当前行放置num完成后，当前行不是最后一行时
					put(++row, num, 0);
					return;
				}else if(row==n-1 && num==2){//当前行放置num完成后，当前行是最后一行时,但放置的数字为2时，重新从第一行开始放置3
					put(0, 3, 0);
					return;
				}else{//row==n-1 && num==3
					System.out.println(Arrays.deepToString(ints));
					count++;
					for(int j=0;j<n;j++)
						if(ints[0][j]==2){
							if(j==n-1)
								return;
							else{
								resetInts();
								put(0, 2,j+1);
								return;
							}
						}
				}
			}else{
				continue;
			}
		}
		//执行到此，表示第row行都不可以放置num，回溯到row-1行，获取列号
		if(row==0){
			return;
		}
		for(int j=0;j<n;j++)
			if(ints[row-1][j]==num){
				ints[row-1][j]=1;
				put(row-1, num,j+1);
			}
	}
	public static boolean check(int row, int col, int num) {
		for(int i=0;i<row;i++){
			if(ints[i][col]==num)//检查同一列上方，左右斜上方 TODO检查列号
				return false;
			if(col+(row-i)<n && ints[i][col+(row-i)]==num)
				return false;
			if(col-(row-i)>=0 && ints[i][col-(row-i)]==num)
				return false;
		}
		return true;
	}
	public static void resetInts(){
		for(int i = 0;i<n;i++)
			for(int j = 0;j<n;j++)
				ints[i][j] = ints_ori[i][j];
	}

}
