
class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int item) {
		this.data = item;
		this.left = null;
		this.right = null;
	}
}

public class RemoveNodeFromLength {

	int k = 4;
	
	void findHeight(Node node, int height){
		if(node == null){
			while(height > k){
				return;
			}
		}else{
			findHeight(node.left, height++);
//			if(height < k){
//				findHeight(node.left, height++);
//				findHeight(node.right, height++);
//			}
		}
	}
	
	public static void main(String[] args) {
		RemoveNodeFromLength nodeFromLength = new RemoveNodeFromLength();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(5);
		root.left.left = new Node(4);
		root.left.left.left = new Node(7);
		root.right.right = new Node(8);
		root.right.right.left = new Node(9);
		
		nodeFromLength.findHeight(root, 1);
	}
	
	
}
