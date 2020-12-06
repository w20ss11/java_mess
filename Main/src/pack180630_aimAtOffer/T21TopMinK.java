package pack180630_aimAtOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class T21TopMinK {
/**
 * 题目描述
	输入n个整数，找出其中最小的K个数。
	例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * */
	public static void main(String[] args) {
		Solution21 solution = new Solution21();
		int[] input = new int[]{4,5,1,6,2,7,3,8};
		solution.GetLeastNumbers_Solution(input, 4);
	}
}
class Solution21 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	if(input.length==0)
    		return new ArrayList<>();
    	if(k>input.length)
    		return new ArrayList<>();
    	
    	quickSort(input,0,input.length-1);
    	ArrayList<Integer> res = new ArrayList<>();
    	for(int i=0;i<k;i++)
    		res.add(input[i]);
		return res;
    }

	private void quickSort(int[] input,int lo,int hi) {
		if(hi<lo || (hi-lo)<2)
			return;
		int key = input[lo];
		int i = lo+1;
		int j = hi;
		while(j>i){
			while(input[j]>key && j>i){
				j--;
			}
			while(input[i]<key && j>i){
				i++;
			}
			if(j>i){
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
				System.out.println(Arrays.toString(input));
			}
		}
		int temp = input[i];
		input[i] = input[lo];
		input[lo] = temp;
		quickSort(input, lo, i-1);
		quickSort(input, i+1, hi);
	}
}