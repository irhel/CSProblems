import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GraphEfficient {
	static class Edge {
		public int to, cost;
		Edge next;
		Edge(int t, int c, Edge n) {
			to = t;
			cost = c;
			next = n;
		}
	}

	static Edge[][] makeUF(Edge[] g) { //We have our original graph. Let's make N trees. 
		Edge[][] Trees = new Edge[g.length][g.length];
		return Trees;
	}
	public static void main(String[] args) {
		int n = 5;
		Edge[][] Trees = new Edge[n + 1][n + 1]; //make singletons
		
		
	}
}