import java.util.Queue;
import java.util.LinkedList;
public class BinarySearchTree {
	class node {
		int value;
		node left, right;

		public node (int value) {
			this.value = value;
			left = right = null;
		}
	} //End_of_node

	node root;

	BinarySearchTree () {
		root = null;
	}
	
	node addNode (node root, int value) {
		if (root == null) {
			root = new node (value);
		}
		else {
			if (value < root.value)
				root.left = addNode (root.left, value);
			else 
				root.right = addNode (root.right, value);
		}
		return root;
	}

	void inOrder (node root) {
		if (root != null) {
			inOrder (root.left);
			System.out.print (root.value + " ");
			inOrder (root.right);
		}
	}
	
	void postOrder (node root) {
		if (root != null) {
			postOrder (root.left);
			postOrder (root.right);
			System.out.print (root.value + " ");
		}
	}
	
	void preOrder (node root) {
		if (root != null) {
			System.out.print (root.value + " ");
			preOrder (root.left);
			preOrder (root.right);
		}
	}
	
	void levelOrder (node root, int level) {
		if (root == null)
			return;
		if (level == 1) 
			System.out.print (root.value + " ");
		else if (level > 1) {
			levelOrder (root.left, level - 1);
			levelOrder (root.right, level - 1);
		}
	}
	
	void levelOrderQueue (node root) {
		Queue<node> que = new LinkedList<node>();
		que.add(root);
		while (!que.isEmpty()) {
			node temp = que.poll();
			System.out.print(" "+ temp.value);
			if (temp.left != null) 
				que.add(temp.left);
			if (temp.right != null)
				que.add(temp.right);
		}
	}
	
	int findHeight (node root) {
		if (root == null)
			return -1;
		int leftCount = findHeight(root.left);
		int rightCount = findHeight (root.right);
		return 1 + Math.max(leftCount, rightCount);
	}
	
	Boolean isBST (node root, int low, int high) {
		if (root == null)
			return true;
		if (root.value <= low || root.value >= high)
			return false;
		return isBST (root.left, low, root.value) && isBST (root.right, root.value, high);
	}

	public
	void insert (int value) {
		root = addNode (root, value);
	}
	
	int minValue () {
		node current = root;
		while (current.left != null)
			current = current.left;
		return current.value;
	}
	
	Boolean isBST () {
		return isBST (root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	void print () {
		System.out.print("Inorder: ");
		inOrder (root);
		
		System.out.print("\nPostOrder: ");
		postOrder (root);
		
		System.out.print("\nPreOrder: ");
		preOrder (root);
		
		System.out.print("\nLevelOrder (using Queue): ");
		levelOrderQueue (root);
		
		int treeHeight = findHeight (root);
		System.out.print("\nLevelOrder (using height): ");
		for (int i =1; i <= treeHeight + 1; i++)
			levelOrder (root, i);
		System.out.println("\nheight: " + treeHeight);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree ();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		tree.print();
		System.out.println("\nMinimum value: "+tree.minValue());
		System.out.println("Is BST?: "+tree.isBST());
		
		System.out.println("\n-----------------------");
        tree.root = tree.new node(4);
        tree.root.left = tree.new node(2);
        tree.root.right = tree.new node(5);
        tree.root.left.left = tree.new node(1);
        tree.root.left.right = tree.new node(3);
        System.out.println("\nMinimum value: "+tree.minValue());
		System.out.println("Is BST?: "+tree.isBST());
		
		System.out.println("\n-----------------------");
        tree.root = tree.new node(3);
        tree.root.left = tree.new node(2);
        tree.root.left.right = tree.new node(5);
        System.out.println("\nMinimum value: "+tree.minValue());
		System.out.println("Is BST?: "+tree.isBST());
        
	}//End_of_main

}//End_of_BinarySeacrhTree
