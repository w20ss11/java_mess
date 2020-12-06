package pack180905_niuke;

import java.util.Scanner;

import cn.wss.Tools.DoubleLinkList;
import cn.wss.Tools.ListNode;

public class Demo1_HuiwenString {
/**
 * 题目描述
	如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
	{1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列, 
	{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
	现在给出一个数字序列，允许使用一种转换操作：
	选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
	现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 * 
 * */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		DoubleLinkList linkList = new DoubleLinkList();
		for(int i=0;i<n;i++){
			linkList.insertLast(scanner.nextInt());
		}
		int count = 0;
		while(linkList.getSize()>1){
			if(linkList.getFirst() == linkList.getLast()){
				linkList.deleteFirst();
				linkList.deleteLast();
			}
			else if(linkList.getFirst() < linkList.getLast()){//前面的数较小
				ListNode node = linkList.deleteFirst();
//				System.out.println(linkList.getFirst()+":"+node.getVal());
				linkList.setFirst(linkList.getFirst()+node.getVal());
				count++;
			}else {//后面的数较小
				ListNode node = linkList.deleteLast();
//				System.out.println(linkList.getLast()+":"+node.getVal());
				linkList.setLast(linkList.getLast()+node.getVal());
				count++;
			}
//			System.out.println("-----------↓----------------------");
			linkList.display();
//			System.out.println(linkList.getSize());
//			System.out.println("-----------↑----------------------");
		}
		System.out.println(count);
		
	}
	
	
	
	
	public static boolean isHuiwenInts(int[] ints){
		int i = 0;
		int j = ints.length-1;
		while(j>i){
			if(ints[i]!=ints[j])
				return false;
			i++;
			j--;
		}
		return true;
	}
	public static boolean isHuiwenString(String string){
		int i = 0;
		int j = string.length()-1;
		while(j>i){
			if(string.charAt(i)!=string.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
