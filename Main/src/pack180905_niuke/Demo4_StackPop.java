package pack180905_niuke;


import java.util.Stack;
public class Demo4_StackPop {

	static char[] in={'a','b','c','d'};

	public static void main(String[] args){
		fun(0,new Stack<Character>(),"");
	}

	@SuppressWarnings("unchecked")
	static void fun(int n, Stack <Character> stk, String sout)
	{   
		//System.out.println("��ǰ����"+n+"    "+"��ǰ�ѳ�"+sout);

		if(n == in.length && stk.isEmpty()){//�����ջ����ˣ���Ҳջ���ˣ�������˳�ջ˳��          ����ǵݹ�Ľ�������
			System.out.println(sout);
		}
		else//��������һ��δ���
		{
			Stack<Character> s1=(Stack<Character>) stk.clone();
			Stack<Character> s2=(Stack<Character>) stk.clone();
			//ѡ����ջ
			if (n <  in.length)//�����δȫ����ջ                       
			{
				s1.push(in[n]);//      ������ջ
				fun(n+1, s1, sout+"");//ִ����һ������
			}
			//ѡ���ջ 
			if (!s2.isEmpty())//���ջ���գ����ң���ջԪ�ز������һ��
			{                                   //�������һ���ַ���ջ֮�������Ѿ�ִ���ȳ�ջ��
				String temp=sout+ s2.peek();//��¼��ջԪ��
				s2.pop();//��ջ
				fun(n, s2, temp);
			}
		}
	}
}
