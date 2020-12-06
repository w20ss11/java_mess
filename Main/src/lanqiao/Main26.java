package lanqiao;

import java.util.Scanner;

public class Main26 {
/**
 * 问题描述
　　最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。所以他准备和奶牛们做一个“Sine之舞”的游戏，
寓教于乐，提高奶牛们的计算能力。
　　不妨设
　　An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
　　Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
　　FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。
输入格式	仅有一个数：N<201。
输出格式	请输出相应的表达式Sn，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
样例输入	3
样例输出	((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] strs_An = new String[n];
		for(int i=0;i<n;i++){//ints_An中第i个元素生成
			strs_An[i] = "";
			String suffix = "";
			for(int j=1;j<=i+1;j++){
				suffix = suffix + ")";
				if(j==i+1)
					strs_An[i] = strs_An[i]+"sin("+j;
				else{
					if(j%2==1)//为奇数时
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
