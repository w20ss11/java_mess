package pack180630_aimAtOffer;
/** 
 * ��Ŀ���� ��̨��
һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������*/
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