package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main23{    
/**��������
�������Ĵ�����һ��������ַ��������������Ҷ��ʹ����������һ���ġ�С������Ϊ���Ĵ����������ġ����ڸ���һ����������һ���ǻ��ĵģ�����������ٵĽ�������ʹ�øô����һ�������Ļ��Ĵ���
���������Ķ����ǣ������������ڵ��ַ�
��������mamad
������һ�ν��� ad : mamda
�����ڶ��ν��� md : madma
���������ν��� ma : madam (���ģ�������)
�����ʽ
������һ����һ������N����ʾ���������ַ����ĳ���(N <= 8000)
�����ڶ�����һ���ַ���������ΪN.ֻ����Сд��ĸ
�����ʽ
����������ܣ�������ٵĽ���������
�����������Impossible
��������
5
mamad
�������
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
    	if(n%2==0){//ż��evenʱ
    		for(int i=0;i<n/2-1;i++){
    			for(int j=n-1-i;j>i;j--){//n-1-iΪ��i��λ�õĶԳ�λ��
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
    	}else{//����ʱ
    		for(int i=0;i<n/2;i++){
    			for(int j=n-1-i;j>i;j--){//n-1-iΪ��i��λ�õĶԳ�λ��
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
