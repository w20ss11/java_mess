package pack180104_mess;

import java.util.Scanner;

public class Main13 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		if(m>=n){
			System.out.println(JumpFloorII(n)%10007);
			return;
		}
		int[] res = new int[n+1];
		for(int i = 1;i<=m;i++){
			res[i] = JumpFloorII(i);
		}
		for(int i=m+1;i<n+1;i++){
			int sum = 0;
			for(int j=i-m;j<=i-1;j++){
				sum = sum+ res[j];
			}
			res[i] = sum%10007;
		}
		System.out.println(res[n]);
	}
    public static int JumpFloorII(int target) {
        if(target==0)
            return 1;
        if(target==1)
            return 1;
        return 2*JumpFloorII(target-1);
    }

}
