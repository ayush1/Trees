package BFSTraversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Graph{
	int vertex;
	LinkedList<Integer> adj[];
	
	Graph(int v){
		vertex = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++){
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	void traverse(int v){
		boolean visited[] = new boolean[vertex];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()){
			v = queue.poll();
			System.out.print(v + " ");
			
			Iterator<Integer> iterator = adj[v].listIterator();
			
			while(iterator.hasNext()){
				int i = iterator.next();
				if(!visited[i]){
					visited[i] = true;
					queue.add(i);
				}
			}
			
		}
	}
}

public class BFS {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		graph.traverse(2);
	}
}
