package defaultPack;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//import java.util.Scanner;

/**
 * @author wss
 *
 */
public class HaHei {

	public static void main(String[] args) {
		String string = "23";
		String pattern = "[0-9]{3}";
		 
	    // ���� Pattern ����
	    Pattern r = Pattern.compile(pattern);
	 
	    // ���ڴ��� matcher ����
	    Matcher m = r.matcher(string);
		boolean bool = m.matches();
		System.out.println(bool);
	}
	public void fun1(){
		String string = "S1#100S2#99S3#98A1#90A2#91";
		ArrayList<String> list = new ArrayList<String>();
		// ��ָ��ģʽ���ַ�������
		String pattern = "#[0-9]{2,}";
		 
	    // ���� Pattern ����
	    Pattern r = Pattern.compile(pattern);
	 
	    // ���ڴ��� matcher ����
	    Matcher m = r.matcher(string);
	    while (m.find()) { 
	        System.out.println(m.group());
	        list.add(m.group());
	    }
	    int len = list.size();
	}
}
