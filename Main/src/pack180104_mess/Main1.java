package pack180104_mess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main1 {
	static ArrayList<String> list;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		list = new ArrayList<>();
		String a = "a";
		String z = "z";
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();
		String inStr = repeat(a, n);
		inStr = inStr + repeat(z, m);
		for (int i = 0; i < inStr.length(); i++) {
			FullPermutation(inStr);
		}
		@SuppressWarnings("unchecked")
		TreeSet<String> treeSet = new TreeSet<String>(list);
        List<String> tempList = new ArrayList<String>();
        tempList.addAll(treeSet);
        System.out.println(tempList.get(k-1));
	}

	public static String repeat(String str,int m){
		String res = "";
		for(int i=0;i<m ;i++){
			res = res+str;
		}
		return res;
	}
	public static List<String> FullPermutation(String input){
		List<String> list = new ArrayList<String>();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			RecursiveMethod(input, i, tmp);
		}
		return list;
	}
	public static void RecursiveMethod(String inStr,int pos,StringBuffer parentData){

		StringBuffer res = new StringBuffer();
		res.append(parentData);
		res.append(inStr.charAt(pos));
		inStr = deleteElement(inStr, pos);
		if (inStr.length() == 0) {
			list.add(res.toString());
//			System.out.println(res.toString());
			return;
		}
		for (int i = 0; i < inStr.length(); i++) {
			RecursiveMethod(inStr, i, res);
		}
	}

	public static String deleteElement(String inStr,int pos){
		StringBuffer outStr = new StringBuffer();
		if (inStr != null) {
			for (int i = 0; i < inStr.length(); i++) {
				if (i != pos) {
					outStr.append(inStr.charAt(i));
				}
			}
		}
		return outStr.toString();
	}
}
