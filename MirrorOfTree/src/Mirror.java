
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

public class Mirror {
	Node root;
	Node temp;
	
	void swap(Node node){
		if(node != null){
			swap(node.left);
			swap(node.right);
			temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}
	
	void printInorder(Node node){
		if(node == null){
			return;
		}else{
			printInorder(node.left);
			System.out.print(" " + node.data);
			printInorder(node.right);
		}
	}
	
	public static void main(String[] args) {
		Mirror mirror = new Mirror();
		mirror.root = new Node(1);
		mirror.root.left = new Node(2);
		mirror.root.right = new Node(3);
		mirror.root.left.left = new Node(4);
		mirror.root.left.left.right = new Node(6);
		mirror.root.left.right = new Node(5);
		
		System.out.println("Inorder traversal of tree before mirroring");
		mirror.printInorder(mirror.root);
		
		System.out.println("\n Inorder traversal of tree after mirroring");
		mirror.swap(mirror.root);
		mirror.printInorder(mirror.root);
	}
}
