package lanqiao;

import java.util.Scanner;

public class Main26 {
/**
 * ��������
�������FJΪ������ţ�ǿ�������ѧ�����Σ�FJ֪����Ҫѧ�����ſΣ�������һ���õ����Ǻ�����������������׼������ţ����һ����Sine֮�衱����Ϸ��
Ԣ�����֣������ţ�ǵļ���������
����������
����An=sin(1�Csin(2+sin(3�Csin(4+...sin(n))...)
����Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
����FJ������ţ�Ǽ���Sn��ֵ���������FJ��ӡ��Sn���������ʽ���Է�����ţ�����⡣
�����ʽ	����һ������N<201��
�����ʽ	�������Ӧ�ı��ʽSn����һ�����з�����������в��ú��ж���Ŀո���С��س�����
��������	3
�������	((sin(1)+3)sin(1�Csin(2))+2)sin(1�Csin(2+sin(3)))+1*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] strs_An = new String[n];
		for(int i=0;i<n;i++){//ints_An�е�i��Ԫ������
			strs_An[i] = "";
			String suffix = "";
			for(int j=1;j<=i+1;j++){
				suffix = suffix + ")";
				if(j==i+1)
					strs_An[i] = strs_An[i]+"sin("+j;
				else{
					if(j%2==1)//Ϊ����ʱ
						strs_An[i] = strs_An[i]+"sin("+j+"-";
					else
						strs_An[i] = strs_An[i]+"sin("+j+"+";
				}
			}
			strs_An[i] = strs_An[i]+suffix;
		}
		String res = "";
		String prefix = "";
		for(int i=0;i<n;i++){
			if(i==0)
				res = strs_An[i]+"+"+n;
			else{
				prefix = prefix+"(";
				res = res + ")"+strs_An[i]+"+"+(n-i);
			}
		}
//		System.out.println(Arrays.toString(strs_An));
		System.out.println(prefix+res);
	}

}
