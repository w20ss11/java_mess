package pack180104_mess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main4{
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		List<Character> list1 = filterSameCode(str);
		for (int k = 0; k < list1.size(); k++) {
			System.out.print(list1.get(k));
		}

	}

	public static List<Character> filterSameCode(String str) {

		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		for (int j = 0; j < list.size(); j++) {
			for (int n = j + 1; n < list.size(); n++) {
				if (list.get(j).equals(list.get(n))) {
					list.remove(n);
					n--;
				}
			}
		}
		return list;
	}

}
