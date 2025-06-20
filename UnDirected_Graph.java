import java.util.*;

class MyGraph{
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public MyGraph(int vertices) {
		for(int i=0;i<vertices;i++) {
			graph.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int u,int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	public void display() {
		for(int i=0;i<graph.size();i++) {
			System.out.print("Vertex " + i + " is connected to: ");
			for(int j=0;j<graph.get(i).size();j++)
				System.out.print(graph.get(i).get(j)+" ");
			System.out.println();
		}
	}

	public void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[graph.size()];
		q.add(start);
		visited[0]=true;

		while(!q.isEmpty()) {
			int front = q.poll();
			System.out.print(front+" ");
			for(int i=0;i<graph.get(front).size();i++) {
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
			System.out.print(top +" ");

			for(int i=0; i<graph.get(top).size();i++) {
				int adj_vertex = graph.get(top).get(i);

				if(!visited[adj_vertex]) {
					s.push(adj_vertex);
					visited[adj_vertex]=true;
				}
			}
		}
	}
}
public class UnDirected_Graph {
	public static void main(String[] args) {
		MyGraph g = new MyGraph(5);
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
