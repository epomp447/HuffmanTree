package HuffmanTree;



public class BinaryTree<E> {
	protected class Node<E> {
		protected Node<E> left;
		protected Node<E> right;
		protected E datavalue;

		public Node(E data) {
			datavalue = data;
			left = null;
			right = null;

		}
	}

	protected Node<E> root;

	public BinaryTree() {
		root = null;// create an empty tree

	}

	protected BinaryTree(Node<E> rootOfATree) {
		root = rootOfATree;
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
	}

	public E getData() {
        if (root != null) {
            return root.datavalue;
        } else {
            return null;
        }
    }
	public BinaryTree<E> getLeftSubtree() {
		if (root != null && root.left != null) {
			return new BinaryTree<E>(root.left);
		} else {
			return new BinaryTree(null);
		}

	}

	public BinaryTree<E> getRightSubtree() {
		if (root != null && root.right != null) {
			return new BinaryTree<E>(root.right);
		} else {
			return new BinaryTree(null);
		}
	}
	public boolean isLeaf() {
        return (root == null || (root.left == null && root.right == null));
    }
    
}
