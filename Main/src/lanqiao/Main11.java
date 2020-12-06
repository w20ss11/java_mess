package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11 {
/**
 * 问题描述
给出n个数，找出这n个数的最大值，最小值，和。
输入格式
第一行为整数n，表示数的个数。
第二行有n个数，为给定的n个数，每个数的绝对值都小于10000。
输出格式
输出三行，每行一个整数。第一行表示这些数中的最大值，第二行表示这些数中的最小值，第三行表示这些数的和。
样例输入
5
1 3 -2 4 5
样例输出
5
-2
11
 * @throws IOException */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		int temp = Integer.parseInt(strs[0]);
		int sum = temp;
		int max = temp;
		int min = temp;
		for(int i=1;i<strs.length;i++){
			int t = Integer.parseInt(strs[i]);
			if(max<t)
				max = t;
			if(min>t)
				min = t;
			sum+=t;
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
	}

}
