package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10 {
/**
 * ��������
����һ������n�����������У�������a�������еĵ�һ�γ����ǵڼ�����
�����ʽ
��һ�а���һ������n��
�ڶ��а���n���Ǹ�������Ϊ���������У������е�ÿ������������10000��
�����а���һ������a��Ϊ�����ҵ�����
�����ʽ
���a�������г����ˣ��������һ�γ��ֵ�λ��(λ�ô�1��ʼ���)���������-1��
��������
6
1 9 4 8 3 9
9
�������
2
���ݹ�ģ��Լ��
1 <= n <= 1000��
 * @throws IOException 
 * @throws NumberFormatException */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine().replaceAll(" ", "");
		char ch = br.readLine().charAt(0);
		int index = line.indexOf(ch);
		System.out.println(index);
	}

}
