/**
写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。

输入描述:
输入一个正浮点数值


输出描述:
输出该数值的近似整数值

输入例子:
5.5

输出例子:
6
**/
import java.util.Scanner;
import java.lang.Math;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
            double d=sca.nextDouble();
			long i;
            i=Math.round(d);
            System.out.println(i);
        }
    }
}