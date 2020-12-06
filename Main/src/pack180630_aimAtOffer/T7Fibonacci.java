package pack180630_aimAtOffer;

public class T7Fibonacci {
/**题目描述 斐波那契数列
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
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