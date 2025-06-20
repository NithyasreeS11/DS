import java.util.*;

class My_Graph{
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public My_Graph(int vertices) {
		for(int i=0;i<vertices;i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int u,int v) {
		graph.get(u).add(v);
	}
	
	public void display() {
		for(int i=0;i<graph.size();i++) {
			System.out.print("Vertex " + i + " has edges to: ");
			
			if(graph.get(i).isEmpty()) {
				System.out.print("None");
			}
			
			else {
				for(int j=0;j<graph.get(i).size();j++) {
						System.out.print(graph.get(i).get(j)+" ");
				}
			}
			
			System.out.println();
		}
	}
	
	public void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[graph.size()];
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int front = q.remove();
			System.out.print(front+" ");
			
			for(int i=0;i<graph.get(front).size(); i++) {
				int adj_vertex = graph.get(front).get(i);
				if(!visited[adj_vertex]) {
					q.add(adj_vertex);
					visited[adj_vertex]=true;
				}
			}
			
		}
	}
	
	public void dfs(int start) {
		Stack<Integer> s = new Stack<>();
		boolean[] visited = new boolean[graph.size()];
		
		s.push(start);
		visited[start] = true;
		
		while(!s.isEmpty()) {
			int top = s.pop();
			System.out.print(top+" ");
			
			for(int i=0;i<graph.get(top).size();i++) {
				int adj_vertex = graph.get(top).get(i);
				if(!visited[adj_vertex]) {
					s.push(adj_vertex);
					visited[adj_vertex]=true;
				}
			}
		}
	}
}
public class Directed_graph {
	public static void main(String[] args) {
		My_Graph g = new My_Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		
		System.out.println("MY GRAPH : ");
		g.display();
		
		System.out.print("\nBreadth First Search : ");
		g.bfs(0);
		
		System.out.print("\n\nDepth First Search : ");
		g.dfs(0);
	}
}
