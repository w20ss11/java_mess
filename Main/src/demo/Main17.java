package demo;

import java.util.ArrayList;

public class Main17 {

	/**
	 * @param args
	 */
	static ArrayList<Double> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = 6;//9999;
		int count = 0;
		list = new ArrayList<Double>();
		for(double i=num;i>=2;i--){
			count = count + opt(i, 0);
		}
		double sum = 1.0;
		for(int j=0;j<list.size();j++){
			sum = sum*list.get(j);
		}
		list = new ArrayList<Double>();
		count = count+opt(sum, 0);
		if(list.get(0)>=1)
			System.out.println(count+1);
		else {
			System.out.println(count);
		}

	}

	private static int opt(double i,int times) {//求某一个数的位数
		if(i<2){
			if(i-1>0.00001)
				list.add(i);
			return times;
		}
		else
			return opt(i/2.0, times+1);
	}

}
