package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11 {
/**
 * ��������
����n�������ҳ���n���������ֵ����Сֵ���͡�
�����ʽ
��һ��Ϊ����n����ʾ���ĸ�����
�ڶ�����n������Ϊ������n������ÿ�����ľ���ֵ��С��10000��
�����ʽ
������У�ÿ��һ����������һ�б�ʾ��Щ���е����ֵ���ڶ��б�ʾ��Щ���е���Сֵ�������б�ʾ��Щ���ĺ͡�
��������
5
1 3 -2 4 5
�������
5
-2
11
 * @throws IOException */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		int temp = Integer.parseInt(strs[0]);
		int sum = temp;
		int max = temp;
		int min = temp;
		for(int i=1;i<strs.length;i++){
			int t = Integer.parseInt(strs[i]);
			if(max<t)
				max = t;
			if(min>t)
				min = t;
			sum+=t;
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
	}

}
