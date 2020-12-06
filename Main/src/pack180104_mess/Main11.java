package pack180104_mess;

import java.util.Scanner;

public class Main11 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		int p=scan.nextInt();
		int q=scan.nextInt();
		int c=0;
		int t=p>q?p:q;
		int u=p<q?p:q;
		if((t+u)>=3) {
			if(t==u) {
				c=t/2;
				int tp=t-2*c;
				c+=tp;
			}
			else{
				int temp=t/2;
				if(temp>=u) 
					c=u;
				else {
					c=temp;
					int tq=t-temp*2;
					int hh=u-temp;
					if(tq==1 && hh>=2)
						c++;				
				}
			}
		}
		System.out.println(c);
	}

}