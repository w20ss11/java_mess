package pack180905_niuke;

import java.util.Scanner;

public class Demo3_CommonString {
/**
 * ��Ŀ����
	���������ַ������ӵ�һ�ַ�����ɾ���ڶ����ַ��������е��ַ���
	���磬���롱They are students.���͡�aeiou������ɾ��֮��ĵ�һ���ַ�����ɡ�Thy r stdnts.��
 * */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		char[] str1 = scanner.nextLine().toCharArray();
		char[] str2 = scanner.nextLine().toCharArray();
		char[] res = new char[str1.length];
		int idx = 0;
		for(int j=0;j<str1.length;j++){
			if(!isInStr2(str1[j], str2))
				res[idx++] = str1[j];
		}
		String reString = new String(res);
		System.out.println(reString);
	}

	public static boolean isInStr2(char ch,char[] str2){
		for(int i=0;i<str2.length;i++)
			if(ch==str2[i])
				return true;
		return false;
	}
}
