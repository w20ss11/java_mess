package lanqiao;

import java.util.Scanner;

public class Main22 {
/**
 * ��������
����FJ��ɳ����д������һЩ�ַ�����
����A1 = ��A��
����A2 = ��ABA��
����A3 = ��ABACABA��
����A4 = ��ABACABADABACABA��
������ ��
���������ҳ����еĹ��ɲ�д���е�����AN��
�����ʽ
��������һ������N �� 26��
�����ʽ
�����������Ӧ���ַ���AN����һ�����з�����������в��ú��ж���Ŀո���С��س�����
��������	3
�������	ABACABA*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String fir = "A";
		String res = "";
		if(n==1){
			System.out.println(fir);
			return;
		}
		for(int i=2;i<=n;i++){
			res = fir+str.charAt(i-1)+fir;
			fir = res;
		}
		System.out.println(res);
	}
}
