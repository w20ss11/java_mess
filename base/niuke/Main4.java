/**
写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）

输入描述:
输入一个十六进制的数值字符串。


输出描述:
输出该数值的十进制字符串。

输入例子:
0xA

输出例子:
10
**/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
            String line=sca.nextLine();
            if(line.startsWith("0x"))
                line=line.substring(2);
            System.out.println(Integer.valueOf(line,16).toString());
        }
    }
}