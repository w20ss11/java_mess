package pack180630_aimAtOffer;


public class T19MergeSortedListnode {
/**
 * 题目描述
	输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
class Solution19 {
    public ListNode Merge(ListNode list1,ListNode list2) {
    	if(list1==null)
    		return list2;
    	if(list2==null)
    		return list1;
    	
    	ListNode head;
    	if(list1.val>list2.val){
    		head = new ListNode(list2.val);
    		list2 = list2.next;
    	}else{
    		head = new ListNode(list1.val);
    		list1 = list1.next;
    	}
    	ListNode point = head;
    	
    	while(list1!=null && list2!=null){
    		if(list1.val>list2.val){
	    		ListNode temp = new ListNode(list2.val);
	    		point.next = temp;
	    		point = point.next;
	    		list2 = list2.next;
	    	}else{
	    		ListNode temp = new ListNode(list1.val);
	    		point.next = temp;
	    		point = point.next;
	    		list1 = list1.next;
	    	}
    	}
    	while(list1!=null){
    		point.next = list1;
    		list1 = list1.next;
    	}
    	while(list2!=null){
    		point.next = list2;
    		list2 = list2.next;
    	}
		return head;
    }
}