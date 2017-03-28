
class Node{
	int data;
	Node left;
	Node right;
	
	Node(int item){
		data = item;
		left= null;
		right = null;
	}
}

public class FindMaxHeight {
	Node root;
	int maxHeight = 0;
	int leftHeight;
	int rightHeight;
	
	int printMaxHeight(Node root){
		
		if(root == null){
			return 0;
		}else{
			leftHeight = printMaxHeight(root.left);
			rightHeight = printMaxHeight(root.right);
		}
		
		maxHeight = Math.max(leftHeight, rightHeight) + 1;
		return maxHeight;
	}
	
	public static void main(String[] args) {
		FindMaxHeight maxHeight = new FindMaxHeight();
		maxHeight.root = new Node(1);
		maxHeight.root.left = new Node(2);
		maxHeight.root.right = new Node(3);
		maxHeight.root.left.left = new Node(4);
		maxHeight.root.left.right = new Node(5);
		maxHeight.root.right.right = new Node(8);
		maxHeight.root.right.right.left = new Node(6);
		maxHeight.root.right.right.right = new Node(7);
		
		System.out.println("max height of tree is " + maxHeight.printMaxHeight(maxHeight.root));
		
	}
}
