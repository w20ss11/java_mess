package pack180630_aimAtOffer;

public class T7Fibonacci {
/**��Ŀ���� 쳲���������
��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
n<=39*/
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rec_fib(2));
		System.out.println(solution.dp(0));
	}

}

class Solution {
    public int Fibonacci(int n) {
		return n;
    }
    public int rec_fib(int n){
    	if(n==0)
    		return 0;
    	if(n<=2)
    		return 1;
		return rec_fib(n-1)+rec_fib(n-2);
    }
    public int dp(int n){
    	if(n==0)
    		return 0;
    	if(n<=2)
    		return 1;
    	int[] ints = new int[n];
    	ints[0] = 1;
    	ints[1] = 1;
    	for(int i=2;i<n;i++){
    		ints[i] = ints[i-1] + ints[i-2];
    	}
    	return ints[n-1];
    }
}