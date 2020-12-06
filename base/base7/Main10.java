package cn.cqupt.wss;

import java.util.Scanner;

public class Main10 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String string = s.nextLine();
		double n = Double.parseDouble(string.split(",")[0]);
		int m = Integer.parseInt(string.split(",")[1]);
		double res = rec(n,m);
		System.out.println(res);
	}

	private static double rec(double n, int m) {
		double res = 0;
		if(m==1)
			return n;
		res = n;
		m--;
		while(m>0){
			n=n/2;
			res = res + 2*n;
			m--;
		}
		return res;
	}

}
