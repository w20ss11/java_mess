package lanqiao;

public class Main13 {
/**
 * ��������
���ڳ���Ϊ5λ��һ��01����ÿһλ��������0��1��һ����32�ֿ��ܡ����ǵ�ǰ�����ǣ�
00000
00001
00010
00011
00100
�밴��С�����˳�������32��01����
�����ʽ
������û�����롣
�����ʽ
���32�У�����С�����˳��ÿ��һ������Ϊ5��01����
�������
00000
00001
00010
00011
<���²���ʡ��>*/
	public static void main(String[] args) {
		String string = "0000";
		for(int i=0;i<=31;i++){
			String binary_str = Integer.toBinaryString(i);
			int len = binary_str.length();
			int need = 5-len;
			if(need>=0){
				System.out.println(string.substring(0, need)+binary_str);
			}else
				System.out.println(binary_str);
		}
	}

}
