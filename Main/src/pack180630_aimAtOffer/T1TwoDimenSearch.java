package pack180630_aimAtOffer;
/**
 * */
public class T1TwoDimenSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * ��Ŀ���� ��ά�����еĲ���
��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������*/

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