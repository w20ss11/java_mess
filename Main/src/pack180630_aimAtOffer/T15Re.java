package pack180630_aimAtOffer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T15Re {

	public static void main(String[] args) {
		String string = "aaa_bbb_dddd_";
		String regex = "_([a-z]+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		while(matcher.find()){
			System.out.println(matcher.group());
		}
	}

}
class Solution15 {
    public boolean match(char[] str, char[] pattern){
    	
		return false;
    }
}