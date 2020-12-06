package defaultPack;
import java.util.ArrayList;

public class HeiHei {

	public static void main(String[] args) {
		String string = "166277388499500";
		ArrayList<String> list = new ArrayList<String>();
		if(string.length()== 15){
			list.add(string.substring(1,3));
			list.add(string.substring(4,6));
			list.add(string.substring(7,9));
			list.add(string.substring(10,12));
			list.add(string.substring(13));
			System.out.println(string.substring(1,3));
		}
		System.out.println(string.charAt(0));
		System.out.println(string.length());
		System.out.println(list.toString());
	}

}
