package com.sandipan.algorithms.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphByList {

	private int vertexCount;
	private Vertex[] vertexNodes;

	public static void main(String[] args) {

		GraphByList graph = new GraphByList(7);
		graph.addVertex("Atlanta");// 0
		graph.addVertex("Austin");// 1
		graph.addVertex("Chicago");// 2
		graph.addVertex("Dallas");// 3
		graph.addVertex("Denver");// 4
		graph.addVertex("Houston");// 5
		graph.addVertex("Washington");// 6

/*		graph.addEdge(0, 5, 800);
		graph.addEdge(0, 6, 600);

		graph.addEdge(1, 3, 200);
		graph.addEdge(1, 5, 160);

		graph.addEdge(2, 4, 1000);

		graph.addEdge(3, 1, 200);
		graph.addEdge(3, 2, 900);
		graph.addEdge(3, 4, 780);

		graph.addEdge(4, 2, 1000);
		graph.addEdge(4, 0, 1400);

		graph.addEdge(5, 0, 800);
		graph.addEdge(5, 2, 800);

		graph.addEdge(6, 0, 600);
		graph.addEdge(6, 3, 1300);*/
		
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 10);
		graph.addEdge(0, 3, 10);
		graph.addEdge(0, 4, 10);
		graph.addEdge(1, 2, 10);
		graph.addEdge(1, 4, 10);
		graph.addEdge(1, 6, 10);
		graph.addEdge(2, 4, 10);
		graph.addEdge(2, 5, 10);
		graph.addEdge(2, 6, 10);
		graph.addEdge(3, 5, 10);
		graph.addEdge(4, 6, 10);
		graph.addEdge(5, 6, 10);
		graph.addEdge(6, 6, 10);

		graph.printGraph(graph);
		
		System.out.println("=========== Breadth First Traversal ===========================");
		
		graph.breadthFirstTraversal(graph);
		
		
		System.out.println("=========== Depth First Traversal ===========================");

		graph.depthFirstTraversal(graph);

		
		System.out.println("=========== Check if the graph has a cycle ===========================");
		System.out.println("Is the directed graph cyclic :: " + graph.isCyclic(graph));
		
	}

	private void printGraph(GraphByList graph) {

		for (int i = 0; i < vertexCount; i++) {
			System.out.println(graph.getVertexNodes()[i].getCityName());

			for (int j = 0; j < graph.getVertexNodes()[i].getEdges().size(); j++) {
				System.out.println(graph.getVertexNodes()[i].getEdges().get(j));
			}
		}
	}

	public GraphByList(int vertexCount) {
		this.vertexNodes = new Vertex[vertexCount];
	}

	public void addEdge(int i, int j, int weight) {		
		vertexNodes[i].getEdges().add(new Edge(i, j, weight));
	}

	public void addVertex(String city) {
		if (vertexCount < vertexNodes.length) {			
			vertexNodes[vertexCount] = new Vertex(vertexCount, city);
			vertexCount++;
			
/*			if(vertexCount < vertexNodes.length)
				Arrays.sort(vertexNodes);*/
			return;
		}
		throw new RuntimeException("Vertex Overflow.");
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public void setVertexCount(int vertexCount) {
		this.vertexCount = vertexCount;
	}

	public Vertex[] getVertexNodes() {
		return vertexNodes;
	}

	public void setVertexNodes(Vertex[] vertexNodes) {
		this.vertexNodes = vertexNodes;
	}

	/**
	 * @author Sandipan Aich
	 *
	 */
	private class Vertex implements Comparable<Vertex>{
		private int index;
		private String cityName;
		private List<Edge> edges;

		public Vertex(int index, String cityName) {
			super();
			this.index = index;
			this.cityName = cityName;
			this.edges = new LinkedList<>();
		}

		public List<Edge> getEdges() {
			return edges;
		}

		public void setEdges(List<Edge> edges) {
			this.edges = edges;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		@Override
		public String toString() {
			return "Vertex [cityName=" + cityName + "]";
		}
		
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.cityName.compareTo(o.getCityName());
		}
	}

	private class Edge {
		private int start;
		private int end;
		private int weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
//			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
			return "Edge [start=" + vertexNodes[start] + ", end=" + vertexNodes[end] + ", weight=" + weight + "]";
		}

	}

	private void breadthFirstTraversal(GraphByList graph)
	{
		Queue<Vertex> queue = new LinkedList<>();

		boolean[] visited = new boolean[graph.getVertexCount()];
		Vertex[] vertices = graph.getVertexNodes();
		queue.add(vertices[0]);
		visited[0] = true;
		
		while(!queue.isEmpty())
		{
			Vertex vertex = queue.poll();
			System.out.println(vertex);
			
			for(Edge edge: vertex.getEdges())
			{
				if(!visited[vertices[edge.end].index])
				{
					queue.add(vertices[edge.end]);
					visited[vertices[edge.end].index] = true;
				}
			}
		}
		
	}

 
	private void depthFirstTraversal(GraphByList graph)
	{
		Stack<Vertex> stack = new Stack<>();

		boolean[] visited = new boolean[graph.getVertexCount()];
		Vertex[] vertices = graph.getVertexNodes();
		stack.push(vertices[0]);
		visited[0] = true;
		
		while(!stack.isEmpty())
		{
			Vertex vertex = stack.pop();
			System.out.println(vertex);
			
			for(Edge edge: vertex.getEdges())
			{
				if(!visited[vertices[edge.end].index])
				{
					stack.push(vertices[edge.end]);
					visited[vertices[edge.end].index] = true;
				}
			}
		}
		
	}

	/**
	 * 
	 */
	
	private boolean checkForCycle(Vertex vertex, GraphByList graph, boolean[] visited, boolean[] recStack)
	{
		
		if(recStack[vertex.index])
			return true;
		if(visited[vertex.index])
			return false;
		
		recStack[vertex.index] = true;
		visited[vertex.index] = true;
		
		List<Edge> edges = vertex.getEdges();
		
		for(Edge edge: edges)
			if(checkForCycle( graph.getVertexNodes()[edge.end] , graph, visited, recStack))
				return true;
		
		recStack[vertex.index] = false;
		
		return false;
	}
	
	private boolean isCyclic(GraphByList graph)
	{
		Vertex[] vertices = graph.getVertexNodes();
		
		boolean[] visited = new boolean[vertices.length];
		boolean[] recStack = new boolean[vertices.length];
		
		for(Vertex vertex : vertices)
		{
			if(checkForCycle(vertex, graph, visited, recStack))
				return true;
		}
		
		return false;
	}
	
}
