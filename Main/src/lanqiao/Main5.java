package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5 {
	/**
	 * ��������
��������n��ʮ��������������������Ƕ�Ӧ�İ˽�������

�����ʽ
��������ĵ�һ��Ϊһ��������n ��1<=n<=10����
����������n�У�ÿ��һ����0~9����д��ĸA~F��ɵ��ַ�������ʾҪת����ʮ��������������ÿ��ʮ�����������Ȳ�����100000��

�����ʽ
�������n�У�ÿ��Ϊ�����Ӧ�İ˽�����������

������ע�⡿
���������ʮ��������������ǰ��0������012A��
��������İ˽�����Ҳ������ǰ��0��*/

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
