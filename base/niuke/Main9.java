/**
编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。

输入描述:
输入N个字符，字符在ACSII码范围内。


输出描述:
输出范围在(0~127)字符的个数。

输入例子:
abc

输出例子:
3
**/
import java.util.Scanner;
import java.util.*;
import java.util.TreeSet;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        TreeSet<Integer> set=new TreeSet<Integer>();
        while(sca.hasNext()){
            //int num=0;
            String line=sca.nextLine();
            for(int i=0;i<line.length();i++){
                int x=(int)line.charAt(i);
                if(x>=0&&x<=127&&!set.contains(x))
                    set.add(x);
            }
            System.out.println(set.size());
        }
    }
}