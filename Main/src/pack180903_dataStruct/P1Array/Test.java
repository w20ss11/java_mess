package pack180903_dataStruct.P1Array;

public class Test {

	public static void main(String[] args) {
		//สýื้
		MyArray array = new MyArray();
		array.insert(4);
		array.insert(14);
		array.insert(33);
		array.insert(1);
		
		array.display();
		System.out.println(array.get(1));
		array.change(0, 133);
		System.out.println(array.get(0));
		
		System.out.println();
		MyOrderArray orderArray = new MyOrderArray();
		orderArray.insert(19);
		orderArray.insert(9);
		orderArray.insert(44);
		orderArray.insert(2);
		orderArray.display();
		System.out.println(orderArray.binarySearch(19));
	}

}
