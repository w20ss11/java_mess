package demo;

import java.util.Arrays;
import java.util.Scanner;

public class Main7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] ints = new int[n];
		int[] ints_sor = new int[n];
		for(int i=0;i<n;i++){
			ints[i] = scanner.nextInt();
			ints_sor[i] = ints[i];
		}
		Arrays.sort(ints_sor);
		int min = ints_sor[0];
		System.out.println(min);
	}

}
