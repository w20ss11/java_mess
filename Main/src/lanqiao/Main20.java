package lanqiao;

import java.util.Scanner;

public class Main20 {
/**
 * 问题描述
　　回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，则左转90度。一开始位于矩阵左上角，方向向下。
输入格式
　　输入第一行是两个不超过200的正整数m, n，表示矩阵的行和列。接下来m行每行n个整数，表示这个矩阵。
输出格式
　　输出只有一行，共mn个数，为输入矩阵回形取数得到的结果。数之间用一个空格分隔，行末不要有多余的空格。
样例输入 3 3
1 2 3
4 5 6
7 8 9
样例输出 1 4 7 8 9 6 3 2 5
样例输入 3 2
1 2
3 4
5 6
样例输出 1 3 5 6 4 2*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] ints = new int[m][n];
		for(int i = 0;i<m;i++)
			for(int j = 0;j<n;j++)
				ints[i][j] = scanner.nextInt();
		int i=0, j=0;
		int w1=0, w2=m-1, w3=n-1, w4=0;
		int step = 0;
		String str = "";
		while(w2>=w4 && w3>=w1){
			if(step==0){//向下
				for(int t=i;t<=w2;t++){
					//System.out.println(ints[t][w1]);
					str = str+ints[t][w1]+" ";
					i = t;
				}
				j = w1;
				w1++;
				step++;
			}else if(step==1){
				for(int t=j+1;t<=w3;t++){
					//System.out.println(ints[w2][t]);
					str = str+ints[w2][t]+" ";
					j = t;
				}
				i = w2;
				w2--;
				step++;
			}else if(step==2){
				for(int t=i-1;t>=w4;t--){
					//System.out.println(ints[t][w3]);
					str = str+ints[t][w3]+" ";
					i = t;
				}
				j = w3;
				w3--;
				step++;
			}else if(step==3){
				for(int t=j-1;t>=w1+1;t--){
					//System.out.println(ints[w4][t]);
					str = str+ints[w4][t]+" ";
					j = t;
				}
				i = w4;
				w4++;
				step=0;
			}
		}
		System.out.println(str.substring(0, str.length()-1));
	}
}
