package pack180630_aimAtOffer;
import java.util.Stack;
/**
 * ��Ŀ���� ������ջʵ�ֶ���
������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�*/
public class T5TwoStacktoQueue {

	public static void main(String[] args) {
		

	}

}
class MyQueue{
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(!stack2.isEmpty())
    		return stack2.pop();
    	while(!stack1.isEmpty())
    		stack2.push(stack1.pop());
		return stack2.pop();
    }
}

class Solution5 {//������
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.add(node);
    }
    
    public int pop() {
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.add(stack1.pop());
    		}
    	}
		return stack2.pop();
    }
}