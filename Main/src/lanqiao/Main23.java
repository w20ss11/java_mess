package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main23{    
/**问题描述
　　回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
　　交换的定义是：交换两个相邻的字符
　　例如mamad
　　第一次交换 ad : mamda
　　第二次交换 md : madma
　　第三次交换 ma : madam (回文！完美！)
输入格式
　　第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
　　第二行是一个字符串，长度为N.只包含小写字母
输出格式
　　如果可能，输出最少的交换次数。
　　否则输出Impossible
样例输入
5
mamad
样例输出
3
 * @throws IOException 
 * @throws NumberFormatException 
 * */
    public static void main(String args[]) throws NumberFormatException, IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	String str = br.readLine();
    	int[] nums = new int[26];
    	for(char ch : str.toCharArray()){
    		//System.out.println((byte)ch);
    		nums[(byte)ch-97]++;
    	}
    	//System.out.println(Arrays.toString(nums));
    	int count = 0;
    	for(int i=0;i<26;i++)
    		if(nums[i]%2==1){
    			count++;
    		}
    	if(count>1){
    		System.out.println("Impossible");
    		return;
    	}
    	int step = 0;
    	if(n%2==0){//偶数even时
    		for(int i=0;i<n/2-1;i++){
    			for(int j=n-1-i;j>i;j--){//n-1-i为第i个位置的对称位置
    				if(str.charAt(i)==str.charAt(j)){
    					step = step + (n-1-i)-j;
    					String prefix = str.substring(0, j);
    					String suffix = str.substring(n-1-i+1);
    					String mid = str.substring(j+1,n-1-i+1);
    					str = prefix+mid+str.charAt(j)+suffix;
    					break;
    				}
    			}
    		}
//    		System.out.println(str);
    		System.out.println(step);
    	}else{//奇数时
    		for(int i=0;i<n/2;i++){
    			for(int j=n-1-i;j>i;j--){//n-1-i为第i个位置的对称位置
    				if(str.charAt(i)==str.charAt(j)){
    					step = step + (n-1-i)-j;
    					String prefix = str.substring(0, j);
    					String suffix = str.substring(n-1-i+1);
    					String mid = str.substring(j+1,n-1-i+1);
    					str = prefix+mid+str.charAt(j)+suffix;
    					break;
    				}
    				if(j==i+1){
    					str = new StringBuffer(str).reverse().toString();
    				}
    			}
    		}
//    		System.out.println(str);
    		System.out.println(step);
    	}
    }    
}    
