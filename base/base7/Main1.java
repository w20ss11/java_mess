package cn.cqupt.wss;

import java.util.Scanner;

public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
        String[] res = new String[T];
		for(int i=0;i<T;i++){
			int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[][] ints = new int[M][2];
            res[i] = judge(N, M, ints);
            System.out.println(judge(N, M, ints));
		}
	}
	public static String judge(int n,int m,int[][] ints){
		return "Yes";
	}

}

