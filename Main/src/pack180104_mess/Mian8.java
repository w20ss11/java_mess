package pack180104_mess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Mian8 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		List<Queue<Character>> queues = new ArrayList<>();
		char[][] chs = new char[n][m];
		char[] temp = new char[m];
		for(int i=0;i<m;i++){
			temp = scanner.nextLine().toCharArray();//m¸ö×Ö·û
			for(int j=0;j<n;j++){
				chs[j][i] = temp[j];
			}
		}
		
		for(int i=0;i<n;i++){
			Queue<Character> queue = new LinkedList<>();
			for(int j=0;j<m;j++){
				queue.add(chs[i][j]);
			}
			queues.add(queue);
		}
		
		for(Queue<Character> q : queues){
			if(q.peek()=='.')
				q.poll();
			else if (q.peek()=='o') {
				
			}else {
				
			}
		}
		
	}
}