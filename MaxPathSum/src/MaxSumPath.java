import javax.swing.text.MaskFormatter;


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

public class MaxSumPath {
	Node root;
	int max_sum = 0;
	int maxSoFar = 0;
	
	int getMaxSum(Node node){
		if(node == null){
			return 0;
		}else{
			int sumLeft = getMaxSum(node.left);
			int sumRight = getMaxSum(node.right);

			if(node.left == null && node.right == null){
				if(node.data > maxSoFar){
					maxSoFar = node.data;
				}else if(sumRight > sumLeft){
					maxSoFar = maxSoFar + node.data;
				}
			}else{
				maxSoFar = maxSoFar + node.data;
			}
			max_sum = maxSoFar;
		}
		return max_sum;
	}
	
	public static void main(String[] args) {
		MaxSumPath sumPath = new MaxSumPath();
		sumPath.root = new Node(1);
		sumPath.root.left = new Node(2);
		sumPath.root.right = new Node(3);
		sumPath.root.left.left = new Node(4);
		sumPath.root.left.right = new Node(5);
		sumPath.root.right.left = new Node(11);
		sumPath.root.right.right = new Node(12);
		
		int maxSum = sumPath.getMaxSum(sumPath.root);
		System.out.println(maxSum);
	}
	
}
