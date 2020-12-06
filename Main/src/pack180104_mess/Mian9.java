package pack180104_mess;

import java.util.Arrays;
import java.util.Scanner;

public class Mian9 {
	static int id;
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		char[][] chs = new char[m][n];
		for(int i=0;i<m;i++){
			chs[i] = scanner.nextLine().toCharArray();
		}
		id = m-1;
		for(int i=0;i<n;i++){//第i列
			for(int j=m-1;j>=0;j--){//第j行
				id = fun(chs,i,j);
			}
		}
		for(int i=0;i<chs.length;i++)
			for(int j=0;j<chs[0].length;j++)
				if(chs[i][j]=='0')
					chs[i][j]='.';
		System.out.println(Arrays.deepToString(chs));
	}

	private static int fun(char[][] chs, int i,int j) {
		switch (chs[i][j]+"") {
		case ".":
			break;
		case "x": 
			return j-1;
		case "o":
			
			break;

		default:
			break;
		}
		return j;
	}
}