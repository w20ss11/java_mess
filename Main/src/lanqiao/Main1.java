package lanqiao;

import java.util.Scanner;

public class Main1 {
/**
 * ��������
����Բ�İ뾶r����Բ�������
�����ʽ
�������һ������r����ʾԲ�İ뾶��
�����ʽ
���һ�У�����һ��ʵ�����������뱣��С�����7λ����ʾԲ�������*/
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		double r = new Scanner(System.in).nextDouble();
		double pi = Math.atan(1.0)*4;
		double s = (float) (pi * r * r);
//		System.out.println(s);
		System.out.println(String.format("%.7f", s));
	}

}
