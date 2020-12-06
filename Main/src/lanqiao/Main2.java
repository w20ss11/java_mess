package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
/**
 * 问题描述
求1+2+3+...+n的值。
输入格式
输入包括一个整数n。
输出格式
输出一行，包括一个整数，表示1+2+3+...+n的值。*/
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		long sum = n*(n+1)/2;
		System.out.println(sum);
	}

}
