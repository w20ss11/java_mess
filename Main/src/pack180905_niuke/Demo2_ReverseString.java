package pack180905_niuke;

import java.util.Scanner;

public class Demo2_ReverseString {
/**
 * ��Ŀ����
	��һ�仰�ĵ��ʽ��е��ã���㲻���á����� I like beijing. �����������Ϊ��beijing. like I
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
