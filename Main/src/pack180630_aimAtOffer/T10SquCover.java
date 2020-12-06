package pack180630_aimAtOffer;

public class T10SquCover {
/**
 * 题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
 * */
	public static void main(String[] args) {
		Solution10 solution = new Solution10();
		int res = solution.RectCover(4);
		System.out.println(res);
	}

}
class Solution10 {
    public int RectCover(int target) {
    	if(target==0)
    		return 0;
    	else if(target==1)
    		return 1;
    	else if(target==2)
    		return 2;
    	return RectCover(target-2)+RectCover(target-1);
    }
}