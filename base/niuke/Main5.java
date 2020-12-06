/**
功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
最后一个数后面也要有空格

详细描述：

函数接口说明：
public String getResult(long ulDataInput)
输入参数：
long ulDataInput：输入的正整数
返回值：
String



输入描述:
输入一个long型整数


输出描述:
按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。

输入例子:
180

输出例子:
2 2 3 3 5
**/
import java.util.Scanner;
import java.util.Collection;
import java.util.*;
import java.lang.Math;
public class Main{
    private boolean isPrime;
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
            int num=sca.nextInt();
            int t;
            List<Integer> list=new ArrayList<Integer>();
            while(!isPrimeNumber(num)){
                for(int j=2;j<num;j++){
                    if(num%j==0&&isPrimeNumber(j)){
                        num=num/j;
                        list.add(j);
                        break;
                    }
                }
            }
            list.add(num);
			Collections.sort(list);
            for(int i:list){
                System.out.print(i+" ");
            }
        }
    }
    public static boolean isPrimeNumber(int num){
        if(num==2)
            return true;
        if(num%2==0)
            return false;
        for(int i=3;i<=(int)Math.sqrt(num);i+=2){
            if(num%i==0)
                return false;
        }
        return true;
    }
}