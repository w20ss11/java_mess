package lanqiao;

public class Main8 {
/**
 * ��������
����153��һ���ǳ��������������������ÿλ���ֵ������ͣ���153=1*1*1+5*5*5+3*3*3��
�������������������������λʮ��������
�����ʽ
��������С�����˳�����������������λʮ��������ÿ����ռһ�С�*/
	public static void main(String[] args) {
		for(int i=1;i<=9;i++){
			for(int j=0;j<=9;j++){
				for(int k=0;k<=9;k++){
					int temp = i*100+j*10+k;
					if(i*i*i+j*j*j+k*k*k==temp)
						System.out.println(temp);
				}
			}
		}
	}

}
