/**
输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。

输入描述:
输入一个int型整数


输出描述:
按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

输入例子:
9876673

输出例子:
37689
**/
import java.util.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
            String line=sca.nextLine();
            line=new StringBuilder(line).reverse().toString();
            List<Character> list=new ArrayList<Character>();
            for(int i=0;i<line.length();i++){
                if(!list.contains(line.charAt(i)))
                	list.add(line.charAt(i));
            }
            Iterator<Character> it=list.iterator();
            while(it.hasNext()){
                char str=it.next();
                System.out.print(str);
            }
        }
    }
}