package lanqiao;

import java.util.Scanner;

public class Main19 {
/**
 * ��������
����������ǰ��ʱ�䣬����Ӣ�ĵĶ���������������
����ʱ����ʱh�ͷ�m��ʾ����Ӣ�ĵĶ����У���һ��ʱ��ķ����ǣ�
�������mΪ0����ʱ��������Ȼ����ϡ�o'clock������3:00������three o'clock����
�������m��Ϊ0����ʱ��������Ȼ�󽫷ֶ���������5:30������five thirty����
����ʱ�ͷֵĶ���ʹ�õ���Ӣ�����ֵĶ���������0~20������
����0:zero, 1: one, 2:two, 3:three, 4:four, 5:five, 6:six, 7:seven, 8:eight, 9:nine, 
10:ten, 11:eleven, 12:twelve, 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen, 
17:seventeen, 18:eighteen, 19:nineteen, 20:twenty��
����30����thirty��40����forty��50����fifty��
�������ڴ���20С��60�����֣����ȶ���ʮ������Ȼ���ټ��ϸ�λ������31���ȶ�30�ټ�1�Ķ�����������thirty one����
����������Ĺ���21:54������twenty one fifty four����9:07������nine seven����0:15������zero fifteen����
�����ʽ
����������������Ǹ�����h��m����ʾʱ���ʱ�ͷ֡����������ǰû��ǰ��0��hС��24��mС��60��
�����ʽ
�������ʱ��ʱ�̵�Ӣ�ġ�
��������
0 15
�������
zero fifteen*/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int h = scanner.nextInt();
		int m = scanner.nextInt();
		String[] strs = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", 
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", 
				"twenty one", "twenty two", "twenty three","twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty",
				"thirty one", "thirty two", "thirty three","thirty four", "thirty five", "thirty six", "thirty seven", "thirty eight", "thirty nine", "forty",
				"forty one", "forty two", "forty three","forty four", "forty five", "forty six", "forty seven", "forty eight", "forty nine", "fifty",
				"fifty one", "fifty two", "fifty three","fifty four", "fifty five", "fifty six", "fifty seven", "fifty eight", "fifty nine", "sixty"};
		if(m==0)
			System.out.println(strs[h]+" o'clock");
		else
			System.out.println(strs[h]+" "+strs[m]);
	}

}
