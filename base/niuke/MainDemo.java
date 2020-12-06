import java.util.ArrayList;
import java.util.Collections;
public class MainDemo{
	public static void main(String[] args){
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			Integer j=new Integer(i);
			list.add(j);
		}
		//Collections.sort(list);
		System.out.println(list.toString());
		list.remove(2);
		System.out.println(list.get(0));
	}
}