import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sca=new Scanner(System.in);
        String input=sca.nextLine();
        String[] strs=input.split(",");
        int n=Integer.parseInt(strs[0]);
		int m=Integer.parseInt(strs[1]);
		int k=Integer.parseInt(strs[2]);
		int temp=n-m+1;
		int p=1;
		int sum=1;
		for(int i=k+1;i<=temp;i++){
			p=p*i;
		}
		sum=p*26;
		for(int j=1;j<=temp-k;j++){
			sum=sum*25;
		}
		System.out.println(sum);
	}
}
