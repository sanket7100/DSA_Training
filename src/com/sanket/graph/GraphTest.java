package com.sanket.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphTest {

	public static void main(String[] args) {
		Graph g1 = new Graph(5);
		g1.addNode(new Node('A'));
		g1.addNode(new Node('B'));
		g1.addNode(new Node('C'));
		g1.addNode(new Node('D'));
		g1.addNode(new Node('E'));

		g1.addEdge('A', 'B');
		g1.addEdge('B', 'C');
		g1.addEdge('C', 'D');
		g1.addEdge('D', 'A');
		g1.addEdge('C', 'E');
		
		g1.printGraph();
		System.out.println(g1.checkEdge('A', 'C'));
	}
}

class Node {
	char data;

	public Node(char d) {
		this.data = d;
	}
}

class Graph {
	int i = 0;
	HashMap<Character, Integer> mp = new HashMap<>();
	ArrayList<Node> nodes;
	int[][] eg;

	public Graph(int n) {
		nodes = new ArrayList<>();
		eg = new int[n][n];
	}

	public void addNode(Node node) {
		nodes.add(node);
		mp.put(node.data, i);
		i++;
	}

	public void addEdge(char src, char dst) {
		eg[mp.get(src)][mp.get(dst)] = 1;
	}

	public boolean checkEdge(char src, char dst) {
		if (eg[mp.get(src)][mp.get(dst)] == 1)
			return true;
		return false;
	}

	public void printGraph() {
		System.out.print("  ");
		for (char c : mp.keySet()) {
			System.out.print(c+" ");
		}
		System.out.println();
		for (char c : mp.keySet()) {
			System.out.print(c+" ");
			for (char c1 : mp.keySet()) {
				if (eg[mp.get(c)][mp.get(c1)] == 1)
					System.out.print(1+" ");
				else
					System.out.print(0+" ");
			}
			System.out.println();
		}
	}

}