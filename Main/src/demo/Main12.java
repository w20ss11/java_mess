package demo;

public class Main12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ints = new int[]{3,34,4,12,5,2};
		f(ints,13,5);

	}

	private static void f(int[] ints, int s, int k) {//sΪÿ�μ�ȥ��ʣ�µ�sum
		if(s==0){
			System.out.println("true");
			return;
		}
		if(s<0)return;
		if(k==-1)return;
		f(ints, s-ints[k], k-1);//ѡȡ�˵�kλ
		f(ints, s, k-1);
	}

}
