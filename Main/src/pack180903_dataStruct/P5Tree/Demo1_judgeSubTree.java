package pack180903_dataStruct.P5Tree;

public class Demo1_judgeSubTree {
/**
 * 题目描述
	输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */
	public static void main(String[] args) {
	}

}
class Solution1 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	if(root1==null)
    		return false;
    	if(root1.val==root2.val)
    		if(travelBwithA(root1,root2))
    			return true;
		return HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2);
    }

	private boolean travelBwithA(TreeNode root1, TreeNode root2) {
		if(root2==null)
			return true;
		return false;
	}
}