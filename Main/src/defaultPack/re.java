package defaultPack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class re {
	public static void main(String[] args){
		String string="14445551314445551311444555141444555141";
		System.out.print("hello");
		String pattern = "\\d{3}2\\d{2}3\\d{2}4\\d{3}5\\d{2}1\\d{2}";
		 
	      // 创建 Pattern 对象
	      Pattern r = Pattern.compile(pattern);
	 
	      // 现在创建 matcher 对象
	      Matcher m = r.matcher(string);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );
	      } else {
	         System.out.println("NO MATCH");
	      }
	}
}
