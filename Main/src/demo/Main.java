package demo;

import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=2;i<=10000;i++){
			if(judge(i)){
				list.add(i);
			}
		}
		System.out.println(list.toString());
		//------------------------------- list 起点数 公差数
		int d = 3;
		for(int start=0;start<list.size()-11;start++){
			for(int m=start+1;m<list.size()-10;m++){
				d = list.get(m)-list.get(start);
				int res= judge_res(list,start,d);
				if(res==-1)
					continue;
				else {
					System.out.println("开始："+start+",结果："+d);
					return;
				}
			}
		}
		
	}

	private static int judge_res(ArrayList<Integer> list, int start, int d) {
		for(int k=1;k<=9;k++){
			if(!list.contains(list.get(start)+k*d))
				return -1;
		}
		return 1;
	}

	private static boolean judge(int i) {
		for(int j=2;j<i;j++)
			if(i%j==0)
				return false;
		return true;
	}

}
