package lanqiao;

import java.util.Scanner;

public class Main3 {
	/**
	 * ��������
����A��B�����A+B��
˵�����ڡ������������ⲿ�֣�������������˼���Լ���Ҫ���Ŀ�ꡣ
�����ʽ
����ĵ�һ�а��������������ɿո�ָ����ֱ��ʾA��B��
�����ʽ
���һ�У�����һ����������ʾA+B��ֵ��*/
	public static void main(String[] args){
		@SuppressWarnings("resource")
		String input = new Scanner(System.in).nextLine();
		int num1 = Integer.parseInt(input.split(" ")[0]);
		int num2 = Integer.parseInt(input.split(" ")[1]);
		System.out.println(num1+num2);
	}
}
