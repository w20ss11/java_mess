package pack180630_aimAtOffer;

import java.util.ArrayList;
import java.util.List;

public class T17ReverseKNode {
/**��Ŀ����
	����һ����������������е���k����㡣
	=========================================
	��������Ѵ��룺Java���룬ͨ��У�顣
	����˼·���£�����ָ�룬���õ�һ��ָ��͵ڶ���ָ�붼ָ��ͷ��㣬
	Ȼ�����õ�һ��ָ����(k-1)���������k���ڵ㡣
	Ȼ������ָ��ͬʱ�����ƶ�������һ����㵽��ĩβ��ʱ�򣬵ڶ����������λ�þ��ǵ�����k���ڵ���
*/
	

	public static void main(String[] args) {
		
	}

}
class Solution171 {
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(head==null || k==0)
    		return null;
    	ListNode p1 = head,p2=head;
    	for(int i=1;i<k;i++)
    		if(p1.next!=null)
    			p1 = p1.next;
    		else
    			return null;
    	while(p1.next!=null){
    		p1 = p1.next;
    		p2 = p2.next;
    	}
		return p2;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution17 {
    public ListNode FindKthToTail(ListNode head,int k) {
    	try {
    		List<Integer> list = new ArrayList<Integer>();
        	while(head!=null){
        		list.add(0, head.val);
        		head = head.next;
        	}
        	ListNode res = new ListNode(list.get(k-1));
        	ListNode point = res;
        	for(int i=k-2;i>=0;i--){
        		ListNode newNode = new ListNode(list.get(i));
        		point.next = newNode;
        		point = point.next;
        		
        	}
    		return res;
		} catch (Exception e) {
			return null;
		}
    }
}