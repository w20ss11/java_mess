package weka_hello;

import java.util.PriorityQueue;
import java.util.Scanner;


public class Main2 {
	
   public static void main(String[] args){
	   
	   Scanner scan = new Scanner(System.in);
   
	   while(scan.hasNext()){
           int n = scan.nextInt();
           int k = scan.nextInt();
           int[] arr = new int[n];
           for (int i = 0; i < n; i++) {
               arr[i] = scan.nextInt();
           }
           PriorityQueue<Integer> queue = new PriorityQueue<>();
          
           for (int i = 4; i < n; i++) {
        	   int[] sr = new int[k];
        	   for(int j = 0;j < k;j++){
        		   
        		   
        	   }
           }
//               arr[i] = scan.nextInt();
           }
	   
	   
	   
	   
	   System.out.println("hello");
   }

}
