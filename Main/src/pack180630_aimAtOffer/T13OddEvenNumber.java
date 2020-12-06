package pack180630_aimAtOffer;

import java.util.Arrays;
/**
 * 题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。*/
public class T13OddEvenNumber {

	public static void main(String[] args) {
		Solution13 solution13 = new Solution13();
		int[] ints = new int[]{3,1,4,2,5};
		solution13.reOrderArray(ints);
		System.out.println(Arrays.toString(ints));
	}

}
class Solution13 {
    public void reOrderArray(int [] array) {
        int lo = 0;
        int hi = array.length-1;
        while(hi>lo){
        	for(int j=hi;j>=0;j--){
        		if(array[j]%2==1){
        			hi = j;
        			break;
        		}
        	}
        	for(int i=lo;i<=array.length;i++){
        		if(array[i]%2==0){
        			lo = i;
        			break;
        		}
        	}
        	if(hi>lo)
        		switchArray(array, hi, lo);
        }
    }
    public void switchArray(int[] array,int i,int j){
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}