package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main4 {
	/**
	 * ��������
��������һ������Ϊn�����У���������а���С�����˳�����С�1<=n<=200
�����ʽ
������һ��Ϊһ������n��
�����ڶ��а���n��������Ϊ�����������ÿ�������ľ���ֵС��10000��
�����ʽ
�������һ�У�����С�����˳��������������С�*/

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String line = br.readLine();
		int[] arr = new int[n];
		System.out.println(n);
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(line.split(" ")[i]);
		}
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++)
			sb.append(arr[i]+" ");
//		System.out.println(Arrays.toString(arr));
		System.out.println(sb.toString());
	}

}
