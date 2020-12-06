package cn.cqupt.wss;

import java.util.*;
public class Main8{
	private static void fun2(int[][] a, int[][] res, int i) {
		int num=a[i][0]/a[i][1];
		int mod=a[i][0]%a[i][1];
		int less=num*(num-1)/2;
		int more=(num+1)*num/2;
		res[i][0]=more*mod+(a[i][1]-mod)*less;
		int t=a[i][0]-(a[i][1]-1);
		res[i][1]=t*(t-1)/2;
	}

	private static void fun1(int[][] a, int[][] res, int i) {
		int temp=a[i][0]-(a[i][1]-1);
		res[i][0]=temp*(temp-1)/2;
		res[i][1]=temp*(temp-1)/2;
	}
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=Integer.parseInt(scan.nextLine());
		int[][] a=new int[N][2];
		for(int i=0;i<N;i++) {
			String[] sss=scan.nextLine().split(" ");
			a[i][0]=Integer.parseInt(sss[0]);
			a[i][1]=Integer.parseInt(sss[1]);
		}
		int[][] intss=new int[N][2];
		for(int i=0;i<N;i++) {
			if(a[i][0]>a[i][1]) {
				if(a[i][1]==1) {
					fun1(a, intss, i);
				}
				else {
					fun2(a, intss, i);
				}
			}
		}
		for(int i=0;i<N;i++) {
			System.out.println(intss[i][0]+" "+intss[i][1]);
		}
	}

}
