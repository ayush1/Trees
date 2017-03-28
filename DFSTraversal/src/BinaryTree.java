
class Node{
	int data;
	Node left;
	Node right;
	
	Node(int item){
		data = item;
		left = null;
		right = null;
	}
}

public class BinaryTree {
	
	Node root;
	
	BinaryTree(){
		root = null;
	}
	
	void printPreOrderTraversal(Node root){
		if(root == null){
			return;
		}else{
			System.out.print(" "+root.data);
			printPreOrderTraversal(root.left);
			printPreOrderTraversal(root.right);
		}
	}
	
	void printInOrderTraversal(Node root){
		if(root == null){
			return;
		}else{
			printInOrderTraversal(root.left);
			System.out.print(" "+root.data);
			printInOrderTraversal(root.right);
		}
	}
	
	void printPostOrderTraversal(Node root){
		if(root == null){
			return;
		}else{
			printPostOrderTraversal(root.left);
			printPostOrderTraversal(root.right);
			System.out.print(" "+root.data);
		}
	}
	
	public static void main(String[] args){
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(1);
		binaryTree.root.left = new Node(2);
		binaryTree.root.right = new Node(3);
		binaryTree.root.left.left = new Node(4);
		binaryTree.root.left.right = new Node(5);
		
		System.out.println("Pre Order Traversal");
		binaryTree.printPreOrderTraversal(binaryTree.root);
		
		System.out.println("\n In Order Traversal");
		binaryTree.printInOrderTraversal(binaryTree.root);
		
		System.out.println("\n Post Order Traversal");
		binaryTree.printPostOrderTraversal(binaryTree.root);
	}
}
