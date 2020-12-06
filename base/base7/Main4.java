package cn.cqupt.wss;

import java.util.Scanner;

public class Main4 {
	int count=0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		if(x==y && x==0){
			System.out.println(0);
			return;
		}
		int n=0;
		for(int i=1;i<x;i++){
			if(i*(i-1)/2==x+y)
				n = i;
		}
		if(x<2*n)
			System.out.println(1);
		int[] ints = new int[x+1];
		
		for(int i=n;i>0;i--){
			
		}
		System.out.println(2);
	}
	public void rec(int x,int n){
		if(x==0)
			return;
	}

}
