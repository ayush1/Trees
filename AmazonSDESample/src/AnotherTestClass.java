/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility  classes
import java.util.*;

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

class AnotherTestClass {
	Node root;
	
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arrA = new int[N];
        int sum = 0;
        int mid = (0 + N)/2;
        int low, high;
        
        for (int i = 0; i < N; i++) {
            arrA[i] = sum + s.nextInt();
            sum = arrA[i];
        }
        
        AnotherTestClass testClass = new AnotherTestClass();
		testClass.root = createBST(arrA, 0, arrA.length);
        
        
        
//        int M = s.nextInt();
//        int[] arrB = new int[M];
//        
//        for (int i = 0; i < M; i++) {
//            arrB[i] = s.nextInt();
//        }
//
//        for(int i = 0; i < arrB.length; i++){
//            
//            	if(arrB[i] > arrA[mid]){
//                    low = mid;
//                    high = N;
//                    mid = (low + high)/2;
//                }else{
//                	low = 0;
//                    high = mid;
//                    mid = (low + high)/2;
//                }
//            System.out.println(mid+1);
//        }
    }

	private static Node createBST(int[] arrA, int start, int end) {
		if(start > end){
			return null;
		}
		
		int mid = (start + end)/2;
		
		Node node = new Node(arrA[mid]);
		node.left = createBST(arrA, start, mid-1);
		node.right = createBST(arrA, mid+1, end);
		
		return node;
	}
}
