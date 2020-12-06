package pack180905_niuke;

import java.util.Scanner;

public class Demo2_ReverseString {
/**
 * 题目描述
	将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
 * */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] strs = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=strs.length-1;i>=0;i--){
			sb.append(strs[i]);
			if(i!=0)
				sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
