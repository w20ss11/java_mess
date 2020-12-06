package pack180630_aimAtOffer;

public class T14MultiArray {
/**
 * 题目描述
	给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
	其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
	不能使用除法。
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Solution14 {
    public int[] multiply(int[] A) {
    	int[] B = new int[A.length];
    	int temp;
    	for(int i=0;i<A.length;i++){
    		temp = 1;
    		for(int j=0;j<A.length;j++){
    			if(j!=i)
    				temp = temp * A[j];
    		}
    		B[i] = temp;
    	}
		return B;
    }
}
