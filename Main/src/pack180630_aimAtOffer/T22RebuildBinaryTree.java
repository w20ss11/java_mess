package pack180630_aimAtOffer;

public class T22RebuildBinaryTree {
/**
 * 题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * */
	public static void main(String[] args) {
		int[] pre = new int[]{1,2,3,4,5,6,7};
		int[] in = new int[]{3,2,4,1,6,5,7};
		reConstructBinaryTree(pre, in);
	}
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		TreeNode root = reConstructBinaryTree(pre, 0,pre.length-1,in,0,in.length-1);
		return root;
	}
	private static TreeNode reConstructBinaryTree(int[] pre, int preSt, int preEn,
			int[] in, int inSt, int inEn) {
		if(preSt > preEn || inSt > inEn)
			return null;
		
		int index = -1;
		TreeNode root = new TreeNode(pre[preSt]);
		for(int i=inSt;i<=inEn;i++){
			if(in[i]==pre[preSt]){
				index = i;
				root.left = reConstructBinaryTree(pre, preSt+1, preSt+index-inSt, 
						in, inSt, index-1);
				root.right = reConstructBinaryTree(pre, preSt+index-inSt+1, preEn, 
						in, index+1, inEn);
				break;
			}
		}
		return root;
	}
}
