package lanqiao;

import java.util.Scanner;

public class Main1 {
/**
 * 问题描述
给定圆的半径r，求圆的面积。
输入格式
输入包含一个整数r，表示圆的半径。
输出格式
输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积。*/
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		double r = new Scanner(System.in).nextDouble();
		double pi = Math.atan(1.0)*4;
		double s = (float) (pi * r * r);
//		System.out.println(s);
		System.out.println(String.format("%.7f", s));
	}

}
