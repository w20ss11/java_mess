package pack180630_aimAtOffer;
import java.util.ArrayList;

/**题目描述 从尾到头打印链表
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。*/
public class T3PrintListFromTailToHead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode ln = new ListNode(0);
		Solution3 solution = new Solution3();
		solution.printListFromTailToHead(ln);
	}

}

//class ListNode {
//	int val;
//	ListNode next = null;
//
//	ListNode(int val) {
//		this.val = val;
//	}
//}

class Solution3 {
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