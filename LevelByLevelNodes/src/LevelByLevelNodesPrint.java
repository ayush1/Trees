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

public class  LevelByLevelNodesPrint{
	Node root;
	int[] nodeElement = new int[1000];
	int index = -1;
	
	void printNextRightNode(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		Queue<Node> childQueue = new LinkedList<Node>();
		
		queue.add(root);
		Node node = null;
		Node childNode = null;
		
		while(!queue.isEmpty()){
			while(queue.size() != 0){
				node = queue.poll();
				if(node != null){
					System.out.print(" " + node.data);
					if(node.left != null){
						childQueue.add(node.left);
					}
					if(node.right != null){
						childQueue.add(node.right);
					}
				}
			}
			System.out.println();
			while(!childQueue.isEmpty()){
				childNode = childQueue.poll();
				queue.add(childNode);
			}
		}
	}
	
	public static void main(String[] args) {
		LevelByLevelNodesPrint byLevelNodes = new LevelByLevelNodesPrint();
		byLevelNodes.root = new Node(1);
		byLevelNodes.root.left = new Node(2);
		byLevelNodes.root.right = new Node(3);
		byLevelNodes.root.left.left = new Node(4);
		byLevelNodes.root.left.right = new Node(5);
		
		System.out.println("Level by level nodes");
		byLevelNodes.printNextRightNode(byLevelNodes.root);
	}
}
