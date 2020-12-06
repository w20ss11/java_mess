package pack180630_aimAtOffer;
/**
 * */
public class T1TwoDimenSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * 题目描述 二维数组中的查找
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/

class Solution6 {
    public boolean Find(int target, int [][] array) {
    	int cols = array[0].length;
    	for(int i=0;i<array.length;i++){
    		if(array[i][cols-1]<target)
    			continue;
    		else{
    			return binarySearch(array[i],target);
    		}
    	}
		return false;
    }

	private boolean binarySearch(int[] is, int target) {
		int lo = 0;
		int hi = is.length-1;
		while(hi>lo){
			int mid = (hi+lo)/2;
			if(is[mid]==target)
				return true;
		}
		return false;
	}
}