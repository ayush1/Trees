
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

public class RootToLeafPath {
	Node root;
	int[] nodeElement = new int[1000];
	int index = -1;
	static int count;
	
	int printRootToLeafpath(Node node){
		if(node != null){
			index++;
			nodeElement[index] = node.data;
			
			printRootToLeafpath(node.left);
			while(nodeElement[index] != node.data){
				nodeElement[index] = 0;
				index--;
			}
			printRootToLeafpath(node.right);
			if(node.left == null && node.right == null){
//				printPath(nodeElement);//To print root to leaf path
				count++;//To find no. of leaf nodes.
			}
		}
		return count;
	}
	
	void printPath(int[] path){
		int index = 0;
		while(path[index] != 0){
			System.out.print(" " + path[index]);
			index++;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		RootToLeafPath path = new RootToLeafPath();
		path.root = new Node(1);
		path.root.left = new Node(2);
		path.root.right = new Node(3);
		path.root.left.left = new Node(4);
		path.root.left.left.right = new Node(6);
		path.root.left.right = new Node(5);
		
		int leafNodes = path.printRootToLeafpath(path.root);
		System.out.println(leafNodes);
	}
}
