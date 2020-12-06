package demo;

import java.util.Arrays;

public class Main14 {

	/**
	 * @param args
	 */
	static char[][] chs;
	public static void main(String[] args) {
		String string = "UDDLUULRULUURLLLRRRURRUURLDLRDRUDDDDUUUUURUDLLRRUUDURLRLDLRLULLURLLRDURDLULLRDDDUUDDUDUDLLULRDLUURRR";
		chs = new char[10][10];
		for(int i=0;i<10;i++){
			chs[i] = string.substring(i*10,i*10+10).toCharArray();
		}
		System.out.println(Arrays.deepToString(chs));
		
		int[][] res = new int[10][10];
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				res[i][j] = opt(res,i,j,1);
		System.out.println(Arrays.deepToString(res));
		int count = 0;
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				if(res[i][j]==1)count++;
		System.out.println(count);
	}

	private static int opt(int[][] res, int i, int j, int time) {
		if(time == 100)
			return 2;
		if(i<0 || j<0 || i>9 || j>9)
			return 1;
		if(res[i][j]!=0)//为其他已知情况
			return res[i][j];
		//计时，100步内还在递归，则跳出，幅值为2
		switch (chs[i][j]) {
		case 'U':
			return opt(res, i-1, j, time+1);
		case 'D':
			return opt(res, i+1, j, time+1);
		case 'L':
			return opt(res, i, j-1, time+1);
		case 'R':
			return opt(res, i, j+1, time+1);
		}
		return 0;
	}

}
