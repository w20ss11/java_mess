package lanqiao;

import java.util.Scanner;

public class Main3 {
	/**
	 * 问题描述
输入A、B，输出A+B。
说明：在“问题描述”这部分，会给出试题的意思，以及所要求的目标。
输入格式
输入的第一行包括两个整数，由空格分隔，分别表示A、B。
输出格式
输出一行，包括一个整数，表示A+B的值。*/
	public static void main(String[] args){
		@SuppressWarnings("resource")
		String input = new Scanner(System.in).nextLine();
		int num1 = Integer.parseInt(input.split(" ")[0]);
		int num2 = Integer.parseInt(input.split(" ")[1]);
		System.out.println(num1+num2);
	}
}
