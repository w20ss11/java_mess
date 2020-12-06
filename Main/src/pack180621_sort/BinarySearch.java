package pack180621_sort;

import java.util.Scanner;
class BinarySearch{
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int[] ints = {0,12,24,35,44,51,68,72,88,90};
		int key = scanner.nextInt();
		System.out.println("0 1  2  3  4  5  6  7  8  9 ");
		System.out.println("0 12 24 35 44 51 68 72 88 90");
		int poi = binarySearch(ints,key);
		System.out.println("The position is "+poi);
	}
	public static int binarySearch(int[] ints,int key){
		int lo = 0;
		int hi = ints.length;
		while(hi>=lo){
			int mid = (hi+lo)/2;
			if(ints[mid]>key){
				hi = mid-1;
			}else if(ints[mid]<key){
				lo = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}