package pack180104_mess;

import java.util.Scanner;

public class Main14 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] ints = new int[n];
		double[] dous = new double[n];
		for(int i=0;i<n;i++){
			ints[i] = scanner.nextInt();
			dous[i] = scanner.nextDouble();
		}
		int count = 0;
		for(int i =0;i<n;i++){
			if(dous[i]>=0.5 && ints[i]==1)
				count++;
			else if (dous[i]<0.5 && ints[i]==0) {
				count++;
			}
		}
		int res = count / n * 100;
		for(int i=0;i<7;i++)
			System.out.println(res);
	}

}
