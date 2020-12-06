package demo;

public class Main3 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum1 = 0;
		for(int i=1;i<=100;i++){
			for(int j=1;j<=i;j++){
				sum1 = sum1 + j;
			}
		}
		System.out.println(sum1);
		
		int sum2 = 0;
		for(int i=1;i<=100;i++)
			sum2 = sum2 + add(i);
		System.out.println(sum2);
		
		//------------------------------------------------
		int sum3 = 0;
		for(int i=26;i<=33;i++){
			sum3 = sum3+i;
		}
		System.out.println("sum3:"+sum3);
		//System.out.println(add1(99, 100));
		//-----------------------------------------------
		for(int i=1;i<100;i++){
			for(int j=i+1;j<101;j++){
				if(add1(i,j)!=236){
//					System.out.println("start:"+i+",end:"+j);
				}
				else {
					System.out.println("### start:"+i+",end:"+j);
					return;
				}
			}
		}
	}
	private static int add1(int start,int end) {
		if(end!=start)
			return end+add1(start,end-1);
		else
			return start;
	}

	private static int add(int i) {
		if(i!=1)
			return i+add(i-1);
		else
			return 1;
	}

}
