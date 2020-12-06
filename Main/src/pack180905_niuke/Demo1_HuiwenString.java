package pack180905_niuke;

import java.util.Scanner;

import cn.wss.Tools.DoubleLinkList;
import cn.wss.Tools.ListNode;

public class Demo1_HuiwenString {
/**
 * ��Ŀ����
	���һ��������������֮���ԭ������һ���ľͳ���������������Ϊ�������С����磺
	{1, 2, 1}, {15, 78, 78, 15} , {112} �ǻ�������, 
	{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} ���ǻ������С�
	���ڸ���һ���������У�����ʹ��һ��ת��������
	ѡ�������������ڵ�����Ȼ��������Ƴ������������������������ֵĺͲ��뵽��������֮ǰ��λ��(ֻ����һ����)��
	���ڶ�����������Ҫ���������Ҫ���ٴβ������Խ����ɻ������С�
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
			else if(linkList.getFirst() < linkList.getLast()){//ǰ�������С
				ListNode node = linkList.deleteFirst();
//				System.out.println(linkList.getFirst()+":"+node.getVal());
				linkList.setFirst(linkList.getFirst()+node.getVal());
				count++;
			}else {//���������С
				ListNode node = linkList.deleteLast();
//				System.out.println(linkList.getLast()+":"+node.getVal());
				linkList.setLast(linkList.getLast()+node.getVal());
				count++;
			}
//			System.out.println("-----------��----------------------");
			linkList.display();
//			System.out.println(linkList.getSize());
//			System.out.println("-----------��----------------------");
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
