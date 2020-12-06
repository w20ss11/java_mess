package cn.cqupt.wss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class Main7 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str1 = null;
		String str2 = null;
		Map<Character,Integer> proxyz1 = new HashMap<Character,Integer>();
		Map<Character,Integer> proxyz2 = new HashMap<Character,Integer>();
		int n = Integer.valueOf(scanner.nextLine());
		ArrayList<String> res = new ArrayList<String>();
		for(int i=0;i<n;i++){
			str1 = scanner.nextLine();
			str2 = scanner.nextLine();
			proxyz1 = new HashMap<Character,Integer>();
			proxyz2 = new HashMap<Character,Integer>();
			res.add(fun(str1, str2,proxyz1,proxyz2));
		}
		for(String str:res)
			System.out.println(str);
	}
 
	private static boolean isTheSame(String str1, String str2,
			Map<Character, Integer> proxyz1, Map<Character, Integer> proxyz2,
			int i) {
		return proxyz1.get(str1.charAt(i)) == proxyz2.get(str2.charAt(i));
	}
	
	public static String fun(String str1, String str2,Map<Character,Integer> proxyz1,Map<Character,Integer> proxyz2) {
 
		if(str1.length() != str2.length())
			return "No";
		for(int i = 0;i<str1.length();i++){
			if((!proxyz1.containsKey(str1.charAt(i))) && (!proxyz2.containsKey(str2.charAt(i)))){
				proxyz1.put(str1.charAt(i), i);
			    proxyz2.put(str2.charAt(i), i);
			}else
				if(fun1(str1, str2, proxyz1, proxyz2, i)){
					if(isTheSame(str1, str2, proxyz1, proxyz2, i))
						return "Yes";
					else
						return "No";
				}
				else 
					return "No";
		}
		return "No";
	}


	private static boolean fun1(String str1, String str2,
			Map<Character, Integer> m1, Map<Character, Integer> m2, int i) {
		return m1.containsKey(str1.charAt(i)) && m2.containsKey(str2.charAt(i));
	}
}

