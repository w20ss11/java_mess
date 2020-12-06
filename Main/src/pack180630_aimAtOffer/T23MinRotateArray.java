package pack180630_aimAtOffer;

public class T23MinRotateArray {
/**
 * 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * */
	public static void main(String[] args) {
		int[] ints = new int[]{3,4,5,1,2};
		System.out.println(minNumberInRotateArray(ints));
	}

	public static int minNumberInRotateArray(int [] array) {
		if(array.length==0)
			return 0;
		int res = rec(array,0,array.length-1);
		return res;
    }

	private static int rec(int[] array, int i, int j) {
		if(j-i<2)
			return array[i]<array[j]?array[i]:array[j];
		
		int mid = (i+j)/2;
		//判断array中mid位置是否满足条件
		if(array[mid]>array[j]){
			return rec(array, mid+1, j);
		}else{
			if(array[mid]<array[mid-1])
				return array[mid];
			else
				return rec(array, i, mid);
		}
	}
}
