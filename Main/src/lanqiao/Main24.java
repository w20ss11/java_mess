package lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main24 {
/**
 * ��������
�����������[a,b]�������������������ֽ⡣
�����ʽ
����������������a��b��
�����ʽ
����ÿ�����һ�����ķֽ⣬����k=a1*a2*a3...(a1<=a2<=a3...��kҲ�Ǵ�С�����)(����ɿ�����)
��������
3 10
�������
3=3
4=2*2
5=5
6=2*3
7=7
8=2*2*2
9=3*3
10=2*5
��ʾ
������ɸ������������Ȼ���ٷֽ⡣
���ݹ�ģ��Լ��
����2<=a<=b<=10000*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		for(int i=m;i<=n;i++){
			System.out.print(i+"=");
			getPrime(i);
			System.out.println();
		}
	}

	private static void getPrime(int num) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int j=2;j<=num;j++){
			if(num%j==0){
				list.add(j);
				num = num/j;
				if(num!=1){
					j = 1;
					continue;
				}
				else
					break;
			}
		}
//		System.out.print("list:"+list.toString());
		for(int k=0;k<list.size();k++){
			if(k<list.size()-1)
				System.out.print(list.get(k)+"*");
			else
				System.out.print(list.get(k));
				
		}
	}

}
