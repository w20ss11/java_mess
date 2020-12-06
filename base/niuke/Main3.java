/**
连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

输入描述:
连续输入字符串(输入2次,每个字符串长度小于100)


输出描述:
输出到长度为8的新字符串数组

输入例子:
abc
123456789

输出例子:
abc00000
12345678
90000000
**/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String line1=s.nextLine();
            String line2=s.nextLine();
            handleStr(line1);
            handleStr(line2);
        }
    }
    public static void handleStr(String line){
        int k=line.length();
        int num=k/8;
        boolean bu=false;
        if((k%8)!=0)
            bu=true;
        for(int j=1;j<=num;j++){
            System.out.println(line.substring((j-1)*8,j*8));
        }
        if(bu){
            handleStrMni(line.substring(num*8));
            bu=false;
        }
    }
    public static void handleStrMni(String line){
        int k=line.length();
			switch(k){
			case 1:System.out.println(line+"0000000");break;
			case 2:System.out.println(line+"000000");break;
			case 3:System.out.println(line+"00000");break;
			case 4:System.out.println(line+"0000");break;
			case 5:System.out.println(line+"000");break;
			case 6:System.out.println(line+"00");break;
			case 7:System.out.println(line+"0");break;
		}
    }
}