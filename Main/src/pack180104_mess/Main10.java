package pack180104_mess;

import java.util.Scanner;

public class Main10 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		char[][] chs = new char[n][m];
		char[] temp = new char[m];
		for(int i=0;i<m;i++){
			temp = scanner.nextLine().toCharArray();//m¸ö×Ö·û
			for(int j=0;j<n;j++){
				chs[j][i] = temp[j];
			}
		}
		for(int i=0;i<n;i++){
			String str = chs[i].toString();
			if(!str.contains("x"))
				for(int j=0;j<m;j++){
					chs[i][m]='.';
				}
			else {
				int id = str.indexOf("x");
				str = str.substring(0, id+1);
			}
		}
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++){
				System.out.print(chs[j][i]);
			}
			System.out.println();
	}

}
