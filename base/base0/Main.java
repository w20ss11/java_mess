import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        while(sca.hasNext()){
            String line=sca.nextLine();
            System.out.println(reverse(line));
        }
    }
    public static String reverse(String sentence){
        String[] strs=sentence.split(" ");
        String res="";
        for(int i=0;i<strs.length;i++){
            res=res+strs[strs.length-i-1]+" ";
        }
        return res;
    }
}