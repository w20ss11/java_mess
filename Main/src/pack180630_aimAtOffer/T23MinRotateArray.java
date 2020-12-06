package pack180630_aimAtOffer;

public class T23MinRotateArray {
/**
 * ��Ŀ����
��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת��
 ���������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
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
		//�ж�array��midλ���Ƿ���������
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
