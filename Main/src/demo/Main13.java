package demo;

public class Main13 {

	/**
	 * @param args
	 */
	static String str1 = "abcdkkk";
	static String str2 = "baabcdkadabc";
	public static void main(String[] args) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
//		char[] res = new char[chs1.length>chs2.length?chs1.length:chs2.length];
		int length = 0;
		int res = opt(chs1,chs2,0,length);
		System.out.println(res);
	}

	private static int opt(char[] chs1, char[] chs2, int d, int length) {
		if(d==chs1.length-1)
			return length;
		
		for(int i=0;i<chs2.length;i++){
			int count = 0;
			if(chs1[d]!=chs2[i])
				continue;
			for(int j=0;j<chs2.length;j++){
				if(chs1[d+j]==chs2[i+j] && d+j<chs1.length-1 && i+j<chs2.length-1)
					count++;
				else
					break;
			}
			length = length>count?length:count;
		}
		return opt(chs1, chs2, d+1, length);
	}

}
