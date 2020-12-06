package pack180903_dataStruct.P5Tree;
/*
 * ��������
 */
public class Tree {
	//���ڵ�
	public TreeNode root;
	
	/**
	 * ����ڵ�
	 * @param value
	 */
	public void insert(int value) {
		//��װ�ڵ�
		TreeNode newNode = new TreeNode(value);
		//���õ�ǰ�ڵ�
		TreeNode current = root;
		//���ø��ڵ�
		TreeNode parent;
		//���rootΪnull��Ҳ���ǵ�һ�����ʱ��
		if(root == null) {
			root = newNode;
			return;
		} else {
			while(true) {
				//���ڵ�ָ��ǰ�ڵ�
				parent = current;
				//�����ǰָ��Ľڵ����ݱȲ����Ҫ��,��������
				if(current.val > value) {
					current = current.left;
					if(current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if(current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * ���ҽڵ�
	 * @param value
	 */
	public TreeNode find(int value) {
		//���õ�ǰ�ڵ㣬�Ӹ��ڵ㿪ʼ
		TreeNode current = root;
		//ѭ����ֻҪ����ֵ�����ڵ�ǰ�ڵ��������
		while(current.val != value) {
			//���бȽϣ��Ƚϲ���ֵ�͵�ǰ�ڵ�Ĵ�С
			if(current.val > value) {
				current = current.left;
			} else {
				current = current.right;
			}
			//������Ҳ���
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	
	/**
	 * ɾ���ڵ�
	 * @param value
	 */
	public boolean delete(int value) {
		//���õ�ǰ�ڵ㣬�Ӹ��ڵ㿪ʼ
		TreeNode current = root;
		
		//Ӧ�õ�ǰ�ڵ�ĸ��ڵ�
		TreeNode parent = root;
		//�Ƿ�Ϊ��ڵ�
		boolean isleft = true;
		
		while(current.val != value) {
			parent = current;
			//���бȽϣ��Ƚϲ���ֵ�͵�ǰ�ڵ�Ĵ�С
			if(current.val > value) {
				current = current.left;
				isleft = true;
			} else {
				current = current.right;
				isleft = false;
			}
			//������Ҳ���
			if(current == null) {
				return false;
			}
		}
		
		//ɾ��Ҷ�ӽڵ㣬Ҳ���Ǹýڵ�û���ӽڵ�
		if(current.left == null && current.right == null) {
			if(current == root) {
				root = null;
			} else if(isleft) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if(current.right == null) {
			if(current == root) {
				root = current.left;
			}else if(isleft) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if(current.left == null) {
			if(current == root) {
				root = current.right;
			} else if(isleft) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else {
			TreeNode successor = getSuccessor(current);
			if(current == root) {
				root = successor;
			} else if(isleft) {
				parent.left = successor;
			} else{
				parent.right = successor;
			}
			successor.left = current.left;
		}
		
		return true;
		
		
	}
	
	public TreeNode getSuccessor(TreeNode delNode) {
		TreeNode successor = delNode;
		TreeNode successorParent = delNode;
		TreeNode current = delNode.right;
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		if(successor != delNode.right) {
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}
	
	/**
	 * ǰ�����
	 */
	public void frontOrder(TreeNode localNode) {
		if(localNode != null) {
			//���ʸ��ڵ�
			System.out.println(localNode.val);
			//ǰ�����������
			frontOrder(localNode.left);
			//ǰ�����������
			frontOrder(localNode.right);
		}
	}
	
	/**
	 * �������
	 */
	public void inOrder(TreeNode localNode) {
		if(localNode != null) {
			//�������������
			inOrder(localNode.left);
			//���ʸ��ڵ�
			System.out.println(localNode.val);
			//��Ѯ����������
			inOrder(localNode.right);
		}
	}
	
	/**
	 * �������
	 */
	public void afterOrder(TreeNode localNode) {
		if(localNode != null) {
			//�������������
			afterOrder(localNode.left);
			//�������������
			afterOrder(localNode.right);
			//���ʸ��ڵ�
			System.out.println(localNode.val);
		}
	}
}
