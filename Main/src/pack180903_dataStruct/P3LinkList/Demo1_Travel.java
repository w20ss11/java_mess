package pack180903_dataStruct.P3LinkList;
import java.util.ArrayList;

public class Demo1_Travel {
/**
 * ��Ŀ����
	����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(listNode!=null){
			temp.add(listNode.val);
			listNode = listNode.next;
		}
		for(int i=temp.size()-1;i>=0;i--)
			res.add(temp.get(i));
		return res;
	}
}