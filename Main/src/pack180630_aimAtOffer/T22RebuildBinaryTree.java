package pack180630_aimAtOffer;

public class T22RebuildBinaryTree {
/**
 * ��Ŀ����
����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
���������ǰ���������������Ľ���ж������ظ������֡�
��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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
