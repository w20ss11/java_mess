package lanqiao;

import java.util.Scanner;

public class TestMain3 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] strs = line.split("/");
		int[] ymd = new int[3];
		for(int i=0;i<3;i++){
			ymd[i] = (strs[i].charAt(0) - '0')*10+(strs[i].charAt(1) - '0');
		}
		process(ymd[0],ymd[1],ymd[2]);
		process(ymd[0],ymd[2],ymd[1]);
		process(ymd[1],ymd[0],ymd[2]);
		process(ymd[1],ymd[2],ymd[0]);
		process(ymd[2],ymd[1],ymd[0]);
		process(ymd[2],ymd[0],ymd[1]);
	}

	private static void process(int y, int m, int d) {
		if(m>12 || d>31 || m==0 || d==0)
			return;
		boolean is_run;
		if(y%400==0 || (y%100!=0 && y%4==0))
			is_run = true;
		else 
			is_run = false;
		if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12){
			if(d<=31)
				print(y,m,d);
			else
				return;
		}else if(m==2){
			if(is_run){
				if(d<=28)
					print(y,m,d);
				else
					return;
			}
			else{
				if(d<=29)
					print(y,m,d);
				else
					return;
			}
				
		}else{
			if(d<=30)
				print(y,m,d);
			else
				return;
		}
	}

	private static void print(int y, int m, int d) {
		String year;
		String month;
		String day;
		if(y>=60)
			year = "19"+y;
		else if(y>9)
			year = "20"+y;
		else
			year = "200"+y;
		if(m>9)
			month = m+"";
		else
			month = "0"+m;
		if(d>9)
			day = d+"";
		else
			day = "0"+d;
		System.out.println(year+"-"+month+"-"+day);
	}

}
