package demo;

import java.util.Arrays;

public class Main6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABC";
		char[] chs = str.toCharArray();
		split(chs,0);
	}

	private static void split(char[] chs, int i) {
		if(i==chs.length-1)System.out.println(Arrays.toString(chs));
		for(int j=i;j<=chs.length-1;j++){
			char temp = chs[i];
			chs[i] = chs[j];
			chs[j] = temp;
			split(chs, i+1);
			temp = chs[i];
			chs[i] = chs[j];
			chs[j] = temp;
		}
	}

}
