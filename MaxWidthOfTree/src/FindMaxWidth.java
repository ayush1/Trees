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

public class FindMaxWidth {

	Node root;
	int max_diameter = 0;
	
	int printMaxWidth(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int currentDiameter;
		
		while(!queue.isEmpty()){
			currentDiameter = queue.size();
			Node node = queue.poll();
			
			if(node.left != null){
				queue.add(node.left);
			}
			if(node.right != null){
				queue.add(node.right);
			}
			
			if(currentDiameter > max_diameter){
				max_diameter = currentDiameter;
			}
			
			currentDiameter = currentDiameter - 1;
			while(currentDiameter != 0){
				node = queue.poll();
				
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
				currentDiameter--;
			}
		}
		return max_diameter;
	}
	
	public static void main(String[] args){
		FindMaxWidth maxWidth = new FindMaxWidth();
		maxWidth.root = new Node(1);
		maxWidth.root.left = new Node(2);
		maxWidth.root.right = new Node(3);
		maxWidth.root.left.left = new Node(4);
		maxWidth.root.left.right = new Node(5);
		maxWidth.root.right.right = new Node(8);
		maxWidth.root.right.right.left = new Node(6);
		maxWidth.root.right.right.right = new Node(7);
		
		System.out.println("Diameter of Tree is " + maxWidth.printMaxWidth(maxWidth.root));
	}
	
}
