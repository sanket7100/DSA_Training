package com.sanket.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyListTest {

	public static void main(String[] args) {

		// Adjacency List = An array/arraylist of linkedlists.
		// Each LinkedList has a unique node at the head.
		// All adjacent neighbors to that node are added to that node's linkedlist

		// runtime complexity to check an Edge: O(v)
		// space complexity: O(v + e)

		Graph1 graph = new Graph1();

		graph.addNode(new Node('A')); // . . . . ..
		graph.addNode(new Node('B')); // .. .
		graph.addNode(new Node('C'));
		graph.addNode(new Node('D'));
		graph.addNode(new Node('E'));

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);

		graph.print();

		// System.out.println(graph.checkEdge(0, 1));
	}
}

class Graph1 {

	ArrayList<LinkedList<Node>> alist;

	Graph1() {
		alist = new ArrayList<>();
	}

	public void addNode(Node node) {
		LinkedList<Node> currentList = new LinkedList<>();
		currentList.add(node);
		alist.add(currentList);
	}

	public void addEdge(int src, int dst) {
		LinkedList<Node> currentList = alist.get(src);
		Node dstNode = alist.get(dst).get(0);
		currentList.add(dstNode);
	}

	public boolean checkEdge(int src, int dst) {
		LinkedList<Node> currentList = alist.get(src);
		Node dstNode = alist.get(dst).get(0);

		for (Node node : currentList) {
			if (node == dstNode) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		for (LinkedList<Node> currentList : alist) {
			for (Node node : currentList) {
				System.out.print(node.data + " -> ");
			}
			System.out.println();
		}
	}
}

//class Node {
//
//	char data;
//
//	Node(char data) {
//		this.data = data;
//	}
//}