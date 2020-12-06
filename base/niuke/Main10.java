/**
描述：
输入一个整数，将这个整数以字符串的形式逆序输出
程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 

输入描述:
输入一个int整数


输出描述:
将这个整数以字符串的形式逆序输出

输入例子:
1516000

输出例子:
0006151

写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：

输入描述:
输入N个字符


输出描述:
输出该字符串反转后的字符串

输入例子:
abcd

输出例子:
dcba
**/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
            String line=sca.nextLine();
            line=new StringBuilder(line).reverse().toString();
            System.out.println(line);
        }
    }
}