import java.util.LinkedList;
import java.util.Queue;


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

public class LevelorderTraversal {
	Node root;
	
	void prinLevelorder(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node node = queue.poll();
			System.out.print(" "+ node.data);
			
			if(node.left != null){
				queue.add(node.left);
			}
			
			if(node.right != null){
				queue.add(node.right);
			}
		}
	}
	
	public static void main(String[] args){
		LevelorderTraversal levelorderTraversal = new LevelorderTraversal();
		levelorderTraversal.root = new Node(1);
		levelorderTraversal.root.left = new Node(2);
		levelorderTraversal.root.right = new Node(3);
		levelorderTraversal.root.left.left = new Node(4);
		levelorderTraversal.root.left.right = new Node(5);
		
		System.out.println("Level order traversal of tree is");
		levelorderTraversal.prinLevelorder(levelorderTraversal.root);
	}
}
