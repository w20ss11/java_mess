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