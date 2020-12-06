package pack180630_aimAtOffer;
/**题目描述 替换空格
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/
public class T2ReplaceSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("a b c");
//		System.out.println(sb.charAt(0));
		
		String res = "";
		for(int i=0;i<sb.length();i++){
			char c = sb.charAt(i);
			if(c==' ')
				res = res+"%20";
			else{
				res = res + c;
			}
		}
		System.out.println(res);

	}

}
