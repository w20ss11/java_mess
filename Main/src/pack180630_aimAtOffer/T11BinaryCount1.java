package pack180630_aimAtOffer;

public class T11BinaryCount1 {
/**
 * ��Ŀ����
����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * */
	public static void main(String[] args) {
		int num = 3;
		System.out.println(Integer.toBinaryString(num));
		char[] chs = Integer.toBinaryString(num).toCharArray();
		System.out.println(count1(chs));
		num = -5;
		System.out.println(Integer.toBinaryString(num));
		chs = Integer.toBinaryString(num).toCharArray();
		System.out.println(count1(chs));
		
	}
	public static int count1(char[] chs){
		int count = 0;
		for(char ch:chs){
			if(ch=='1'){
				count++;
			}
		}
		return count;
	}

}

class Solution11 {
    public int NumberOf1(int n) {
        char[] chs = Integer.toBinaryString(n).toCharArray();
		return count1(chs);
    }
    public int count1(char[] chs){
		int count = 0;
		for(char ch:chs){
			if(ch=='1'){
				count++;
			}
		}
		return count;
	}
}