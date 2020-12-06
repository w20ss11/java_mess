package lanqiao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main6 {
	/**
	 * 问题描述
　　123321是一个非常特殊的数，它从左边读和从右边读是一样的。
　　输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
输入格式
　　输入一行，包含一个正整数n。
输出格式
　　按从小到大的顺序输出满足条件的整数，每个整数占一行。
样例输入
52
样例输出
899998
989989
998899*/
	public static void main(String[] args){
		@SuppressWarnings("resource")
		int n = new Scanner(System.in).nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<=9;i++){
			for(int j=0;j<=9;j++){
				for(int k=0;k<=9;k++){
					if(2*i+2*j+2*k==n){
						list.add(Integer.parseInt(""+i+j+k+k+j+i));
						list.add(Integer.parseInt(""+i+k+j+j+k+i));
						list.add(Integer.parseInt(""+j+i+k+k+i+j));
						list.add(Integer.parseInt(""+k+i+j+j+i+k));
						list.add(Integer.parseInt(""+k+j+i+i+j+k));
						list.add(Integer.parseInt(""+j+k+i+i+k+j));
					}else if(2*i+2*j+k==n){
						if(i==j)
							list.add(Integer.parseInt(""+i+i+k+i+i));
						else{
							list.add(Integer.parseInt(""+i+j+k+j+i));
							list.add(Integer.parseInt(""+j+i+k+i+j));
						}
					}else if(2*i+j+2*k==n){
						if(i==k)
							list.add(Integer.parseInt(""+i+i+j+i+i));
						else{
							list.add(Integer.parseInt(""+i+k+j+k+i));
							list.add(Integer.parseInt(""+k+i+j+i+k));
						}
					}else if(i+2*j+2*k==n){
						if(k==j)
							list.add(Integer.parseInt(""+j+j+i+j+j));
						else{
							list.add(Integer.parseInt(""+k+j+i+j+k));
							list.add(Integer.parseInt(""+j+k+i+k+j));
						}
					}
				}
			}
		}
		//去重
		HashSet<Integer> hashSet = new HashSet<Integer>(list);
		list.clear();
		list.addAll(hashSet);
		Collections.sort(list);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
