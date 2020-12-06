/**
给定n个字符串，请对n个字符串按照字典序排列。 
输入描述:
输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。


输出描述:
数据输出n行，输出结果为按照字典序排列的字符串。

输入例子:
9
cap
to
cat
card
two
too
up
boat
boot

输出例子:
boat
boot
cap
card
cat
to
too
two
up
**/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
            String str=sca.nextLine();
            int num=Integer.valueOf(str);
            List<String> list=new ArrayList<String>();
            for(int i=0;i<num;i++){
                String line=sca.nextLine();
                list.add(line);
            }
			Collections.sort(list);
            Iterator<String> it=list.iterator();
            while(it.hasNext()){
                String s=it.next();
                System.out.println(s);
            }
        }
    }
}