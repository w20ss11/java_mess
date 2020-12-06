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