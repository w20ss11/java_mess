/**
计算字符串最后一个单词的长度，单词以空格隔开。

输入描述:
一行字符串，非空，长度小于5000。


输出描述:
整数N，最后一个单词的长度。

输入例子:
hello world

输出例子:
5
**/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        String input=sca.nextLine();
        String[] strs=input.split(" ");
        int i=strs.length;
        String s=strs[i-1];
        System.out.println(s.length());
    }
}