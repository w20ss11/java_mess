package pack180903_dataStruct.P5Tree;
/*
 * 二叉树类
 */
public class Tree {
	//根节点
	public TreeNode root;
	
	/**
	 * 插入节点
	 * @param value
	 */
	public void insert(int value) {
		//封装节点
		TreeNode newNode = new TreeNode(value);
		//引用当前节点
		TreeNode current = root;
		//引用父节点
		TreeNode parent;
		//如果root为null，也就是第一插入的时候
		if(root == null) {
			root = newNode;
			return;
		} else {
			while(true) {
				//父节点指向当前节点
				parent = current;
				//如果当前指向的节点数据比插入的要大,则向左走
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
	 * 查找节点
	 * @param value
	 */
	public TreeNode find(int value) {
		//引用当前节点，从根节点开始
		TreeNode current = root;
		//循环，只要查找值不等于当前节点的数据项
		while(current.val != value) {
			//进行比较，比较查找值和当前节点的大小
			if(current.val > value) {
				current = current.left;
			} else {
				current = current.right;
			}
			//如果查找不到
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	
	/**
	 * 删除节点
	 * @param value
	 */
	public boolean delete(int value) {
		//引用当前节点，从根节点开始
		TreeNode current = root;
		
		//应用当前节点的父节点
		TreeNode parent = root;
		//是否为左节点
		boolean isleft = true;
		
		while(current.val != value) {
			parent = current;
			//进行比较，比较查找值和当前节点的大小
			if(current.val > value) {
				current = current.left;
				isleft = true;
			} else {
				current = current.right;
				isleft = false;
			}
			//如果查找不到
			if(current == null) {
				return false;
			}
		}
		
		//删除叶子节点，也就是该节点没有子节点
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
	 * 前序遍历
	 */
	public void frontOrder(TreeNode localNode) {
		if(localNode != null) {
			//访问根节点
			System.out.println(localNode.val);
			//前序遍历左子树
			frontOrder(localNode.left);
			//前序遍历右子树
			frontOrder(localNode.right);
		}
	}
	
	/**
	 * 中序遍历
	 */
	public void inOrder(TreeNode localNode) {
		if(localNode != null) {
			//中序遍历左子树
			inOrder(localNode.left);
			//访问根节点
			System.out.println(localNode.val);
			//中旬遍历右子树
			inOrder(localNode.right);
		}
	}
	
	/**
	 * 后序遍历
	 */
	public void afterOrder(TreeNode localNode) {
		if(localNode != null) {
			//后序遍历左子树
			afterOrder(localNode.left);
			//后序遍历右子树
			afterOrder(localNode.right);
			//访问根节点
			System.out.println(localNode.val);
		}
	}
}
