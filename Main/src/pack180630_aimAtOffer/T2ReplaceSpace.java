package pack180630_aimAtOffer;
/**��Ŀ���� �滻�ո�
��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��*/
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
