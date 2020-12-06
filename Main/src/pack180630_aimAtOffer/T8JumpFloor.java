package pack180630_aimAtOffer;
/** 
 * 题目描述 跳台阶
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。*/
public class T8JumpFloor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 solution1 = new Solution1();
		int res = solution1.JumpFloor(4);
		System.out.println(res);
	}

}
class Solution1 {
	int count = 0;
    public int JumpFloor(int target) {
		rec_floor(target);
		return count;
    }
    public void rec_floor(int rest_step){
    	if(rest_step<0)
    		return;
    	if(rest_step==0){
    		count++;
    		return;
    	}
    	rec_floor(rest_step-1);
    	rec_floor(rest_step-2);
    }
}