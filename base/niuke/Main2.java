/**
写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。

输入描述:
输入一个有字母和数字以及空格组成的字符串，和一个字符。


输出描述:
输出输入字符串中含有该字符的个数。

输入例子:
ABCDEF
A

输出例子:
1
**/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
		String s1;
		String s2;
		int num=0;
        while(sca.hasNext()){
            s1=sca.nextLine();
            s2=sca.nextLine();
            s1=s1.toUpperCase();
            s2=s2.toUpperCase();
			for(int i=0;i<s1.length();i++){
				if(String.valueOf(s1.charAt(i)).equals(s2))
					num++;
			}
			System.out.println(num);
		}
    }
}登录路径：https://renren.acmcoder.com/cand/login 

登录帐号：renren
登录密码：ntxkp4