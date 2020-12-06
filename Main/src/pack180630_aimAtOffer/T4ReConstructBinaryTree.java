package pack180630_aimAtOffer;

/**��Ŀ���� �ؽ�������
����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡���������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�*/
public class T4ReConstructBinaryTree {

	public static void main(String[] args) {
		
	}

}

//  Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


class Solution2 {
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		TreeNode res = reConstructBinaryTree(pre,0,pre.length,in,0,in.length);
		return res;
	}
	public TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,
			int endIn) {
		if(startPre>endPre||startIn>endIn)
            return null;
		TreeNode treeNode = new TreeNode(pre[startPre]);
		for(int i=startIn;i<=endIn;i++){
			if(pre[startPre]==in[i]){
				treeNode.left = reConstructBinaryTree(pre, startPre+1, startPre+1+(i-startIn), in, startIn, i-1);
				treeNode.right = reConstructBinaryTree(pre, endPre-(endIn-i+1), endPre, in, i+1, endIn);
			}
		}
		return treeNode;
	}
}