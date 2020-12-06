/**
输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。

输入描述:
 输入一个整数（int类型）


输出描述:
 这个数转换成2进制后，输出1的个数

输入例子:
5

输出例子:
2
**/
import java.util.Scanner;
import java.lang.Integer;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
			int num=0;
            String line=sca.nextLine();
			String binary=Integer.toBinaryString(Integer.valueOf(line));
			for(int i=0;i<binary.length();i++){
				if(binary.charAt(i)=='1')
					num++;
			}
			System.out.println(num);
        }
    }
}