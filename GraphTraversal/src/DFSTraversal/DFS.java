package DFSTraversal;

import java.util.LinkedList;
import java.util.ListIterator;

class Graph{
	int vertex;
	LinkedList<Integer> adj[];
	boolean visited[];
	
	Graph(int v){
		vertex = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++){
			adj[i] = new LinkedList();
		}
		visited = new boolean[v];
	}
	
	void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	void traverse(int v, boolean visited[]){
		visited[v] = true;
		System.out.print(v + " ");
		
		ListIterator<Integer> iterator = adj[v].listIterator();
		while(iterator.hasNext()){
			int i = iterator.next();
			if(!visited[i]){
				traverse(i, visited);
			}
		}
	}
}

public class DFS {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		graph.traverse(2, graph.visited);
	}
}
