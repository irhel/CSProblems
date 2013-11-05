import java.util.*;
import java.io.*;


public class ComputerSites {
	static class UF {
		public static int[] A;
		public UF(int numElements) {
			A = new int[numElements];
			for(int i = 1; i < numElements; i++)
				A[i] = -1;
		}
		public static void union(int a, int b) {
			int rootA = find(a);
			int rootB = find(b);
			if(rootA == rootB) return;
			if(A[rootB] < A[rootA]) {
				A[rootB] += A[rootA];
				A[rootA] = rootB;
			}
			else {
				A[rootA] += A[rootB];
				A[rootB] = rootA;
			}
		}
		public static int find(int x) {
			if(A[x] < 0) 
				return x;
			else {
				A[x] = find(A[x]);
				return A[x];
			}
		}
	}
	static class Connection implements Comparable<Connection>{
		public int from, to, cost;
		public Connection(int f, int t, int c) {
			from = f;
			to = t;
			cost = c;
		}
		public int compareTo(Connection C) {
			return cost - C.cost;
		}
	}
	static class Edge {
		public int to, cost;
		Edge next;
		public Edge(int t, int c, Edge n) {
			to = t;
			cost = c;
			next = n;
		}
	}
	static  Edge[] getMST(List<Connection> L, Edge[] g, int n) {
		Edge[] MST = new Edge[n + 1];
		Collections.sort(L); //Obtain the edges sorted by their weight. 
		UF U = new UF(n + 1);
		for(Connection C : L) { //Let's build the Minimum Spanning Tree
			int from = C.from;
			int to = C.to;
			if(U.find(from) != U.find(to)) {
				MST[from] = new Edge(to, C.cost, MST[from]);
				U.union(from, to);
			}
		}
		return MST;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			StringBuilder out = new StringBuilder();
			int cost1 = 0;
			int cost2 = 0;
			int n = in.nextInt();
			Edge[] g1 = new Edge[n + 1];
			Edge[] g2 = new Edge[n + 1];
			Edge[] MST1;
			Edge[] MST2;
			List<Connection> L1 = new ArrayList<Connection>();
			List<Connection> L2 = new ArrayList<Connection>();
			int num;
			for(int i = 1; i <= n - 1; i++) {
				int from, to, cost;
				from = in.nextInt();
				to = in.nextInt();
				cost = in.nextInt();
				cost1+=cost;
			}
			int K = in.nextInt();
			for(int i = 1; i <= K; i++) {
				int from, to, cost;
				from = in.nextInt();
				to = in.nextInt();
				cost = in.nextInt();
				g2[from] = new Edge(to, cost, g2[from]);
				g2[to] = new Edge(from, cost, g2[to]);
				L2.add(new Connection(from, to, cost));
				
			}
			int M = in.nextInt();
			for(int i = 1; i <= M; i++) {
				int from, to, cost;
				from = in.nextInt();
				to = in.nextInt();
				cost = in.nextInt();
				L1.add(new Connection(from, to, cost));
				L2.add(new Connection(from, to, cost));
				g2[from] = new Edge(to, cost, g2[from]);
				g2[to] = new Edge(from, cost, g2[to]);
			}
		
			MST2 = getMST(L2, g2, n);
			for(int i = 1; i < MST2.length; i++) {
				for(Edge e = MST2[i]; e != null; e = e.next)
					cost2+=e.cost;
			}
			 cost2 = Math.min(cost1, cost2);
			 out.append(cost1 + "\n" + cost2 + "\n");
			 System.out.print(out);
		}
		System.exit(0);
	}
}