package lanqiao;

import java.util.Scanner;

public class Main14 {
/**
 * ��������
����һ����ݣ��ж���һ���ǲ������ꡣ
���������֮һ����ʱ����һ�������꣺
1. �����4�ı���������100�ı�����
2. �����400�ı�����
��������ݶ��������ꡣ
�����ʽ
�������һ������y����ʾ��ǰ����ݡ�
�����ʽ
���һ�У������������������꣬�����yes���������no��*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		int year = new Scanner(System.in).nextInt();
		if(year%4==0 && year%100!=0){
			System.out.println("yes");
			return;
		}
		if(year%400==0){
			System.out.println("yes");
			return;
		}
		System.out.println("no");
	}

}
