package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5 {
	/**
	 * 问题描述
　　给定n个十六进制正整数，输出它们对应的八进制数。

输入格式
　　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。

输出格式
　　输出n行，每行为输入对应的八进制正整数。

　　【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。*/

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int n = Integer.parseInt(br.readLine());
		String[] strs = new String[n];
		for(int i=0;i<n;i++){
//			strs[i] = toOctal(br.readLine());
			int temp = Integer.parseInt(br.readLine(),16);
			strs[i] = Integer.toOctalString(temp);
		}
		for(int i=0;i<n;i++){
			System.out.println(strs[i]);
		}
	}

//	private static String toOctal(String readLine) {
//		return null;
//	}

}
