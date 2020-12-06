/**
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符

接口说明
/**
 * 反转句子
 * 
 * @param sentence 原句子
 * @return 反转后的句子

public String reverse(String sentence);
 
 
 

输入描述:
将一个英文语句以单词为单位逆序排放。


输出描述:
得到逆序的句子

输入例子:
I am a boy

输出例子:
boy a am I
**/
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
            String line=sca.nextLine();
            String res=reverse(line);
            System.out.println(res);
        }
    }
 /**
 * 反转句子
 * 
 * @param sentence 原句子
 * @return 反转后的句子
 */
    
    public static String reverse(String sentence){
        String[] strs=sentence.split(" ");
        String res="";
        for(int i=0;i<strs.length;i++){
            res=res+strs[strs.length-i-1]+" ";
        }
        return res;
    }
}