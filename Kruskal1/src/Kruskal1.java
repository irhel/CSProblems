import java.util.*;
public class Kruskal1 {
	public static Map<String, Integer> map = new HashMap<String, Integer>();
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
		public int from;
		public int to;
		public int cost;
		public Connection(int f, int t, int c) {
			from = f;
			to = t;
			cost = c;
		}
		public int compareTo(Connection A) {
			return cost - A.cost;
		}
	}
	static class Edge {
		public int to, cost;
		Edge next;
		Edge(int t, int c, Edge n) {
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
		int n = 4; // Number of vertices.
		int nfrom, nto;
		Scanner in = new Scanner(System.in);
		Edge[] g = new Edge[n + 1];
		
		List<Connection> L = new ArrayList<Connection>();
		for(int i = 1; i <= 5; i++) { //7 edges
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			g[from] = new Edge(to, cost, g[from]);
			L.add(new Connection(from, to, cost));
		}
		int res = 0;
		Edge[] MST = getMST(L, g, n);
		for(int i = 1; i < MST.length; i++) {
			for(Edge e = MST[i]; e != null; e = e.next)  {
				res+=e.cost;
			}
		}
		System.out.println(res);
	}
}

