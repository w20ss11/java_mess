package pack180104_mess;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

   public static List<String> FullPermutation(String input){
       List<String> list = new ArrayList<String>();
       StringBuffer tmp = new StringBuffer();
       for (int i = 0; i < input.length(); i++) {
           RecursiveMethod(input, i, tmp);
       }
       return list;
   }
   public static void RecursiveMethod(String inStr,int pos,StringBuffer parentData){

       StringBuffer res = new StringBuffer();
       res.append(parentData);
       res.append(inStr.charAt(pos));
       inStr = deleteElement(inStr, pos);
       if (inStr.length() == 0) {
           System.out.println(res.toString());
           return;
       }
       for (int i = 0; i < inStr.length(); i++) {
           RecursiveMethod(inStr, i, res);
       }
   }

   public static String deleteElement(String inStr,int pos){
       StringBuffer outStr = new StringBuffer();
       if (inStr != null) {
           for (int i = 0; i < inStr.length(); i++) {
               if (i != pos) {
                   outStr.append(inStr.charAt(i));
               }
           }
       }
       return outStr.toString();
   }
   public static void main(String[] args) {
       String inStr = "abcdefg";
       for (int i = 0; i < inStr.length(); i++) {
           FullPermutation(inStr);
       }
   }
}
