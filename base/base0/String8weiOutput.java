import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String line1=s.nextLine();
            String line2=s.nextLine();
            handleStr(line1);
            handleStr(line2);
        }
    }
    public static void handleStr(String line){
        int k=line.length();
        int num=k/8;
        boolean bu=false;
        if((k%8)!=0)
            bu=true;
        for(int j=1;j<=num;j++){
            System.out.println(line.substring((j-1)*8,j*8));
        }
        if(bu){
            handleStrMni(line.substring(num*8));
            bu=false;
        }
    }
    public static void handleStrMni(String line){
        int k=line.length();
			switch(k){
			case 1:System.out.println(line+"0000000");break;
			case 2:System.out.println(line+"000000");break;
			case 3:System.out.println(line+"00000");break;
			case 4:System.out.println(line+"0000");break;
			case 5:System.out.println(line+"000");break;
			case 6:System.out.println(line+"00");break;
			case 7:System.out.println(line+"0");break;
		}
    }
}