import java.util.LinkedList;
import java.util.ListIterator;


class Graph{
	int vertex;
	LinkedList<Integer> adj[];
	boolean visited[];
	boolean recStack[];
	boolean isCycleExist;
	
	Graph(int v){
		vertex = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++){
			adj[i] = new LinkedList();
		}
		visited = new boolean[v];
		recStack = new boolean[v];
	}
	
	void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	boolean isCyclic(int v, boolean visited[], boolean recStack[]){
		if(!visited[v] && !recStack[v]){
			recStack[v] = true;
			visited[v] = true;
		}
			
		ListIterator<Integer> iterator = adj[v].listIterator();
		while(iterator.hasNext()){
			int element = iterator.next();
			if(!visited[element] && isCyclic(element, visited, recStack)){
				return true;
			}else if(recStack[element]){
				return true;
			}
		}
		recStack[v] = false;
		return false;
	}
}

public class DetectCycle {
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
//		graph.addEdge(3, 5);
//		graph.addEdge(3, 1);
//		graph.addEdge(5, 4);
//		graph.addEdge(5, 2);
//		graph.addEdge(1, 7);
//		graph.addEdge(2, 6);
//		graph.addEdge(4, 6);
//		graph.addEdge(7, 2);
//		graph.addEdge(7, 8);
//		graph.addEdge(6, 8);
		
		if(graph.isCyclic(2, graph.visited, graph.recStack)){
			System.out.println("Cycle Exist");
		}else{
			System.out.println("Cycle NOT Exist");
		}
	}
}
