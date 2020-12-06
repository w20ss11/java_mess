package lanqiao;

public class Main13 {
/**
 * 问题描述
对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
00000
00001
00010
00011
00100
请按从小到大的顺序输出这32种01串。
输入格式
本试题没有输入。
输出格式
输出32行，按从小到大的顺序每行一个长度为5的01串。
样例输出
00000
00001
00010
00011
<以下部分省略>*/
	public static void main(String[] args) {
		String string = "0000";
		for(int i=0;i<=31;i++){
			String binary_str = Integer.toBinaryString(i);
			int len = binary_str.length();
			int need = 5-len;
			if(need>=0){
				System.out.println(string.substring(0, need)+binary_str);
			}else
				System.out.println(binary_str);
		}
	}

}
