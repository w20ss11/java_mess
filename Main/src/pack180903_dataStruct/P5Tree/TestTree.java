package pack180903_dataStruct.P5Tree;

public class TestTree {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(10);
		tree.insert(20);
		tree.insert(15);
		tree.insert(3);
		tree.insert(4);
		tree.insert(90);
		
		System.out.println(tree.root.val);
		System.out.println(tree.root.right.val);
		System.out.println(tree.root.right.left.val);
		System.out.println(tree.root.left.val);
		System.out.println("------------- ¡ü left right --------------------");
		
		TreeNode node = tree.find(3);
		System.out.println(node.val);
		System.out.println("------------- ¡üfind ---------------------");
		
		
		tree.frontOrder(tree.root);
		System.out.println("------------- ¡üfrontOrder ---------------------");
		
		tree.inOrder(tree.root);
		System.out.println("------------- ¡üinOrder ---------------------");
		tree.afterOrder(tree.root);
		System.out.println("------------- ¡üafterOrder ---------------------");
		tree.delete(90);
		tree.inOrder(tree.root);
		System.out.println("------------- ¡üdelete ---------------------");
	}
}
