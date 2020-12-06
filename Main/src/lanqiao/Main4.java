package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main4 {
	/**
	 * 问题描述
　　给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
输入格式
　　第一行为一个整数n。
　　第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
输出格式
　　输出一行，按从小到大的顺序输出排序后的数列。*/

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String line = br.readLine();
		int[] arr = new int[n];
		System.out.println(n);
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(line.split(" ")[i]);
		}
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++)
			sb.append(arr[i]+" ");
//		System.out.println(Arrays.toString(arr));
		System.out.println(sb.toString());
	}

}
