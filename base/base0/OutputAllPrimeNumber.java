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