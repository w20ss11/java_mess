package pack180903_dataStruct.P3LinkList;

public class TestLinkList {

	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		linkList.insertFirst(34);
		linkList.insertFirst(23);
		linkList.insertFirst(12);
		linkList.insertFirst(0);
		linkList.insertFirst(-1);
		
		linkList.display();
		
		System.out.println("deleteFirst");
		linkList.deleteFirst();
		linkList.display();
		
		System.out.println("find");
		ListNode node = linkList.find(23);
		System.out.println(node.val);
		
		System.out.println("delete");
		ListNode node1 = linkList.delete(0);
		System.out.println(node1.val);
		System.out.println();
		linkList.display();
	}

}
