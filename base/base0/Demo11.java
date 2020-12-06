public class Main{
    public static void main(String[] args){
        String input="hello world";
        String[] strs=input.split(" ");
        int i=strs.length;
        String s=strs[i-1];
        System.out.println(s.length);
    }
}