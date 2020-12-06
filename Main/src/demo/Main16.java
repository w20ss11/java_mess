package demo;

import java.util.Scanner;

public class Main16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine().trim().replace("|", "a");
		int length = opt(str,str.length()-1);
		System.out.println(length);
//		String s = "xx|xx".trim();
//		s=s.replace("|", "a");
//		System.out.println(Arrays.toString(s.split("a")));
	}

	private static int opt(String str, int d) {
		if(d==0)return str.length();
		if(!str.contains("("))return str.length();
		for(int i=d;i>=0;i--){
			if(str.charAt(i)=='(')
				for(int j=i+1;j<str.length();j++){
					if(str.charAt(j)==')'){
//						System.out.println(str.substring(i+1,j));
						String temp = str.substring(i+1,j);//²»°üº¬À¨ºÅ
						if(temp.contains("a")){
							String[] strs = temp.split("a");
							String compare = strs[0].length()>strs[1].length()?strs[0]:strs[1];
							str = str.substring(0,i)+compare+str.substring(j+1);
							return opt(str, str.length()-1);
						}else{
							str = str.substring(0,i)+temp+str.substring(j+1);
							return opt(str, str.length()-1);
						}
					}else{
						continue;
					}
				}
			else{
				continue;
			}
		}
		return -1;
	}

}
