package com.sandipan.algorithms.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphByListBkp {

	private int vertexCount;
	private String[] vertices;
	private Vertex[] vertexNodes;
	private List<Edge>[] pathList;

	public static void main(String[] args) {

		GraphByListBkp graph = new GraphByListBkp(7);
		graph.addVertex("Atlanta");// 0
		graph.addVertex("Austin");// 1
		graph.addVertex("Chicago");// 2
		graph.addVertex("Dallas");// 3
		graph.addVertex("Denver");// 4
		graph.addVertex("Houston");// 5
		graph.addVertex("Washington");// 6

		graph.addEdge(0, 5, 800);
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

		graph.addEdge(6, 0, 600);
		graph.addEdge(6, 3, 1300);

		graph.printGraph(graph);
	}

	private void printGraph(GraphByListBkp graph) {
		for (int i = 0; i < vertexCount; i++) {
			System.out.println(graph.getVertices()[i]);
			for (int j = 0; j < pathList[i].size(); j++) {
				System.out.println(pathList[i].get(j));
			}
		}
		
		System.out.println("========================");

		for (int i = 0; i < vertexCount; i++) {
			System.out.println(graph.getVertexNodes()[i].getCityName());

			for (int j = 0; j < graph.getVertexNodes()[i].getEdges().size(); j++) {
				System.out.println(graph.getVertexNodes()[i].getEdges().get(j));
			}
		}
	
	
	
	}

	public GraphByListBkp(int vertexCount) {
		this.vertices = new String[vertexCount];
		this.vertexNodes = new Vertex[vertexCount];
		this.pathList = new List[vertexCount];
	}

	public void addEdge(int i, int j, int weight) {
		pathList[i].add(new Edge(i, j, weight));
		
		vertexNodes[i].getEdges().add(new Edge(i, j, weight));
		
	}

	public void addVertex(String city) {
		if (vertexCount < vertices.length) {
			vertices[vertexCount] = city;
			pathList[vertexCount] = new LinkedList<>();
			
			
			vertexNodes[vertexCount] = new Vertex(vertexCount, city);
					
			vertexCount++;
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

	public String[] getVertices() {
		return vertices;
	}

	public void setVertices(String[] vertices) {
		this.vertices = vertices;
	}
	
	public Vertex[] getVertexNodes() {
		return vertexNodes;
	}

	public void setVertexNodes(Vertex[] vertexNodes) {
		this.vertexNodes = vertexNodes;
	}



	private class Vertex {
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
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

	}
}
