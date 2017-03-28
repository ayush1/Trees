
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

public class ChangeWithLeftTreeSum {
	Node root;
	int newNode;
	
	int getLeftTreeSum(Node node){
		if(node ==  null){
			return 0;
		}else{
			int leftSum = getLeftTreeSum(node.left);
			int rightSum = getLeftTreeSum(node.right);
			
			if(node.left != null){
				newNode = node.data + leftSum;
				node.data = newNode;
			}
		}
		return node.data;
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
	
	public static void main(String[] args) {
		ChangeWithLeftTreeSum  leftTreeSum = new ChangeWithLeftTreeSum();
		leftTreeSum.root = new Node(1);
		leftTreeSum.root.left = new Node(2);
		leftTreeSum.root.right = new Node(3);
		leftTreeSum.root.left.left = new Node(9);
		leftTreeSum.root.left.right = new Node(6);
		leftTreeSum.root.right.left = new Node(4);
		leftTreeSum.root.right.left.right = new Node(5);
		
//		leftTreeSum.root = new Node(1);
//		leftTreeSum.root.left = new Node(2);
//		leftTreeSum.root.right = new Node(3);
//		leftTreeSum.root.left.left = new Node(4);
//		leftTreeSum.root.left.right = new Node(5);
		
		System.out.println("Inorder traversal of original tree: ");
		leftTreeSum.printInOrderTraversal(leftTreeSum.root);
		
		System.out.println("\n Inorder traversal of changed tree: ");
		leftTreeSum.getLeftTreeSum(leftTreeSum.root);
		leftTreeSum.printInOrderTraversal(leftTreeSum.root);
	}
	
}
