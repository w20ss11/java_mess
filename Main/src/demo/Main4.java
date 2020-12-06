package demo;

import java.util.Arrays;

public class Main4 {

	/**
	 * @param args
	 */
	static int count = 0;
	public static void main(String[] args) {
		int[] ints = {0,1,2,3,4,5,6,7,8,9};
		search(ints,1);
		System.out.println(count);
	}

	private static void search(int[] ints, int i) {
		if(i==ints.length-1){
			judge(ints);
		}
		for(int j=i;j<ints.length-1;j++){
			int temp = ints[i];
			ints[i] = ints[j];
			ints[j] = temp;
			search(ints, i+1);
			temp = ints[i];
			ints[i] = ints[j];
			ints[j] = temp;
		}
	}

	private static void judge(int[] ints) {
		if(ints[1]<ints[3] && ints[1]<ints[4] && ints[2]<ints[4] && ints[2]<ints[5]
		&& ints[3]<ints[6] && ints[3]<ints[7] && ints[4]<ints[7] && ints[4]<ints[8] 
		&& ints[5]<ints[8] && ints[5]<ints[9]){
			System.out.println(Arrays.toString(ints));
			count++;
		}
	}

}
