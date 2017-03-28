import java.util.LinkedList;
import java.util.Queue;


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

public class CheckCousinNode {
	Node root;
	Queue<Node> parentQueue = new LinkedList();
	Queue<Node> childQueue = new LinkedList();
	
	void checkCousin(Node node, int node1, int node2){
		Node[] arr = new Node[100];
		int i = 0;
		boolean isFirstNodeFound = false;
		boolean isSecondNodeFound = false;
		
		parentQueue.add(node);
		
		while(!parentQueue.isEmpty()){
			while(parentQueue.size() != 0){
				Node parentNode = parentQueue.poll();
				if(parentNode != null){
					if(parentNode.left != null && parentNode.right != null){
						if(parentNode.left.data != node1 || parentNode.left.data != node2){
							childQueue.add(parentNode.left);
						}else{
							arr[i] = parentNode;
							i++;
							isFirstNodeFound = true;
						}
						if(parentNode.right.data != node1 || parentNode.right.data != node2){
							childQueue.add(parentNode.right);
						}else{
							arr[i] = parentNode;
							i++;
							isSecondNodeFound = true;
						}
					}
				}
			}
			if(isFirstNodeFound && isSecondNodeFound){
				System.out.println("Yes");
				break;
			}else{
				arr = null;
			}
			while(!childQueue.isEmpty()){
				parentQueue.add(childQueue.poll());
			}
		}
		System.out.println("No");
	}
	
	public static void main(String[] args) {
		CheckCousinNode cousinNode = new CheckCousinNode();
		cousinNode.root = new Node(6);
		cousinNode.root.left = new Node(3);
		cousinNode.root.right = new Node(5);
		cousinNode.root.left.left = new Node(7);
		cousinNode.root.left.right = new Node(8);
		cousinNode.root.right.left = new Node(1);
		cousinNode.root.right.right = new Node(13);
		cousinNode.root.left.left.left = new Node(4);
		cousinNode.root.left.left.left.right = new Node(2);
		cousinNode.root.left.right.left = new Node(10);
		cousinNode.root.left.right.right = new Node(11);
		cousinNode.root.right.left.left = new Node(12);
		cousinNode.root.right.left.right = new Node(14);
		cousinNode.root.right.right.left = new Node(15);
		cousinNode.root.right.right.right = new Node(16);
		
		cousinNode.checkCousin(cousinNode.root, 3, 5);
	}
}
