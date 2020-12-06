package cn.wss.Tools;

public class KMP {
	public static void main(String[] args){
        String a = "ababa";
        String b = "ssdfgasdebdatsundua";
//        String a = "ababa";
//        String b = "ssdfgasdbababa";
//		String a = "ababc";
//        String b = "abaacababcac";
        int[] next = kmpnext(a);
        int res = kmp(b, a,next);
        System.out.println(res);
        System.out.println("----------------------------");
        for(int i = 0; i < next.length; i++){
            System.out.println(next[i]);            
        }
        System.out.println("---------------------------");
        System.out.println(next.length);
    }
	
    public static int kmp(String str, String dest,int[] next){//str�ı���  dest ģʽ��
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                return i-j+1;
            }
        }
        return 0;
    }
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length(); i++){
            while(j > 0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}