package pack180104_mess;

import java.util.Scanner;

public class Main12 {
	static int[] time1;
	static int[] fen1;
	static int[] time2;
	static int[] fen2;
	static int[] res;
	static int remainTime = 120;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		time1 = new int[n];
		fen1 = new int[n];
		time2 = new int[n];
		fen2 = new int[n];
		for(int i=0;i<n;i++){
			time1[i] = scanner.nextInt();
			fen1[i] = scanner.nextInt();
			time2[i] = scanner.nextInt();
			fen2[i] = scanner.nextInt();
		}
		res = new int[n];
		for(int i=0;i<n;i++){
			res[i] = opt(i);
		}
		System.out.println(res[n-1]);
		
	}
	public static int opt(int n){
		
		
		if(n==0){//第1题
			if(remainTime>=time2[n]){
				remainTime = remainTime - fen2[n];
				return fen2[n];
			}else if (remainTime>=time1[n]) {
				remainTime = remainTime - fen1[n];
				return fen1[n];
			}else
				return 0;
		}
		//比较res[n-1]t:all res[n-1]+t:all-t1[n-1] res[n-1]+t:all-t2[n-1]
//		res[]
		int value1 = 0;
		int value2 = 0;
		if(remainTime<=0){
			return res[n-1];
		}
		if(remainTime+time1[n-1]>=time1[n]){
			value1 = res[n-1] + fen1[n];
		}
		if(remainTime+time2[n-1]>=time2[n]){
			value2 = res[n-1] + fen2[n];
		}
		
		
		if(res[n-1]>=value1 && res[n-1]>=value2)
			return res[n-1];
		else if(value1>=res[n-1] && value1>=value2){
			remainTime = remainTime +time1[n-1] - time1[n];
			return value1;
		}else if(value2>=res[n-1] && value2>=value1){
			remainTime = remainTime +time2[n-1] - time2[n];
			return value2;
		}
		return res[n-1];
	}

}
