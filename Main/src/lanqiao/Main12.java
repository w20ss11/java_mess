package lanqiao;

import java.util.Scanner;

public class Main12 {
/**
 * ��������
������ĸ�������һЩ������ͼ�Σ����������һ�����ӣ�
ABCDEFG
BABCDEF
CBABCDE
DCBABCD
EDCBABC
����һ��5��7�е�ͼ�Σ����ҳ����ͼ�εĹ��ɣ������һ��n��m�е�ͼ�Ρ�
�����ʽ:����һ�У�������������n��m���ֱ��ʾ��Ҫ�����ͼ�ε�������������
�����ʽ:���n�У�ÿ��m���ַ���Ϊ���ͼ�Ρ�
��������:5 7
�������
ABCDEFG
BABCDEF
CBABCDE
DCBABCD
EDCBABC*/
	public static void main(String[] args) {
		String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		String subStr = string.substring(0, n);
		System.out.println(subStr);
		for(int i=1;i<m;i++){
			String suffix = null;
			if(n-i<0)
				suffix = "";
			else
				suffix = subStr.substring(0, n-i);
			String prefix = new StringBuffer(string.substring(1, i+1)).reverse().toString();
			System.out.println(prefix+suffix);
		}
	}

}
