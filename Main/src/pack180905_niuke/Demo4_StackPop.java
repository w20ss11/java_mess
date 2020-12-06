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
		//System.out.println("当前进度"+n+"    "+"当前已出"+sout);

		if(n == in.length && stk.isEmpty()){//如果入栈完毕了，且也栈空了，就输出此出栈顺序          这个是递归的结束条件
			System.out.println(sout);
		}
		else//以上其中一项未完成
		{
			Stack<Character> s1=(Stack<Character>) stk.clone();
			Stack<Character> s2=(Stack<Character>) stk.clone();
			//选择入栈
			if (n <  in.length)//如果是未全部入栈                       
			{
				s1.push(in[n]);//      继续入栈
				fun(n+1, s1, sout+"");//执行下一个操作
			}
			//选择出栈 
			if (!s2.isEmpty())//如果栈不空，并且，入栈元素不是最后一个
			{                                   //当到最后一个字符入栈之后，上面已经执行先出栈了
				String temp=sout+ s2.peek();//记录出栈元素
				s2.pop();//出栈
				fun(n, s2, temp);
			}
		}
	}
}
