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

public class NextRightNodeOfKey {
	Node root;
	int[] nodeElement = new int[1000];
	int index = -1;
	Node nextNode = null;
	
	void printNextRightNode(Node root, int key){
		Queue<Node> queue = new LinkedList<Node>();
		Queue<Node> childQueue = new LinkedList<Node>();
		
		queue.add(root);
		Node node = null;
		Node childNode = null;
		boolean isElementFound = false;
		
		while(!queue.isEmpty()){
			while(queue.size() != 0){
				node = queue.poll();
				if(node != null){
					if(node.data == key){
						nextNode = queue.poll();
						if(nextNode != null){
							isElementFound = true;
							break;
						}else{
							isElementFound = false;
							break;
						}
					}
					if(node.left != null){
						childQueue.add(node.left);
					}
					if(node.right != null){
						childQueue.add(node.right);
					}
				}
			}
			while(!childQueue.isEmpty()){
				childNode = childQueue.poll();
				queue.add(childNode);
			}
		}
		
		if(isElementFound){
			System.out.println("Element found is: " + node.data);
		}else{
			System.out.println("Element Not found");
		}
	}
	
	public static void main(String[] args) {
		NextRightNodeOfKey rightNodeOfKey = new NextRightNodeOfKey();
		rightNodeOfKey.root = new Node(10);
		rightNodeOfKey.root.left = new Node(2);
		rightNodeOfKey.root.right = new Node(6);
		rightNodeOfKey.root.left.left = new Node(8);
		rightNodeOfKey.root.left.right = new Node(4);
		rightNodeOfKey.root.right.right = new Node(5);
		
		rightNodeOfKey.printNextRightNode(rightNodeOfKey.root, 5);
	}
}
