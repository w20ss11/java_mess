package pack180903_dataStruct.P4LinkList;

public class TestDoubleLinkList {
	public static void main(String[] args) {
		DoubleLinkList dl = new DoubleLinkList();
		dl.insertLast(45);
		dl.insertLast(56);
		dl.insertLast(90);
		dl.display();
		
		
		while(!dl.isEmpty()) {
			dl.deleteFirst();
			dl.display();
		}
	}
}
