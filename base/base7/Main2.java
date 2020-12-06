package cn.cqupt.wss;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		int k = Integer.parseInt(string.split(":")[1]);
		String[] strs = string.split(":")[0].split("-");
		int[] ints1 = getArray(strs[0]);
		int[] ints2 = getArray(strs[1]);
		//2,4,2,7,7-3,2,5,6,1,9:6
		int[] res = new int[k];
		Arrays.sort(ints1);
		Arrays.sort(ints2);
		System.out.println(Arrays.toString(ints1));
		System.out.println(Arrays.toString(ints2));
		int i=ints1.length-1,j=ints2.length-1,index=0;
		while(index<k){
			res[index++] = ints1[i] + ints2[j];
			if(i==0){
				j--;
				continue;
			}
			if(j==0){
				i--;
				continue;
			}
			if(ints1[i-1]+ints2[j]>ints1[i]+ints2[j-1]){
				i--;
				continue;
			}
			else {
				j--;
				continue;
			}
			
		}
		for(i=0;i<k;i++){
			System.out.print(res[i]);
			if(i!=k-1)
				System.out.print(",");
		}
	}

	private static int[] getArray(String string) {
		String[] ss = string.split(",");
		int[] ints = new int[ss.length];
		for(int i=0;i<ss.length;i++){
			ints[i] = Integer.parseInt(ss[i]);
		}
		return ints;
	}

}
