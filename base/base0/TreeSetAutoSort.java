import java.util.Scanner;
import java.util.TreeSet;
 
public class Main
{
    public static void main(String[] args) {

        TreeSet<Integer> set=new TreeSet<Integer>();
            int[] n={33,25,99,76,12};
			for(int i=0;i<n.length;i++){
				set.add(n[i]);
			}
            for(Integer i:set){
                System.out.println(i);
            }
    }
}