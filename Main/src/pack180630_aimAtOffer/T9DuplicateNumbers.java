package pack180630_aimAtOffer;

public class T9DuplicateNumbers {
/**
 * ��Ŀ����
	��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
	���ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * */
	public static void main(String[] args) {
//		int[] ints = new int[]{1,3,3,6};
//		Solution9 solution = new Solution9();
		
		

	}
	

}
class Solution9 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	for(int i=0;i<length-1;i++){
    		int check = numbers[i];
    		for(int j=i+1;j<length;j++){
    			if(numbers[j]==check){
    				duplication[0] = check;
    				return true;
    			}
    				
    		}
    	}
		return false;
    
    }
}