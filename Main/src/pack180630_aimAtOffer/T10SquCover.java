package pack180630_aimAtOffer;

public class T10SquCover {
/**
 * ��Ŀ����
���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ���
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