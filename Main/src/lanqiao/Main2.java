package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
/**
 * ��������
��1+2+3+...+n��ֵ��
�����ʽ
�������һ������n��
�����ʽ
���һ�У�����һ����������ʾ1+2+3+...+n��ֵ��*/
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		long sum = n*(n+1)/2;
		System.out.println(sum);
	}

}
