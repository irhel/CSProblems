import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;


public class XeniaAndTree {
	static class Edge {
		public int to, cost;
		Edge next;
		public Edge(int t, int c, Edge n) {
			to = t;
			cost = c;
			next = n;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		Edge[] g = new Edge[N + 1];
		int[] parentOf = new int[N + 1];
		parentOf[1] = 1;
		for(int i = 1; i <= N - 1; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			parentOf[to] = from;
			g[from] = new Edge(to, 0, g[from]);
			g[to] = new Edge(from, 0, g[to]);
		}
		int[] d = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			d[i] = dist(1, i, g);
		}
		Queue<Integer> L = new LinkedList<Integer>();
		int res = 0;
		for(int i = 1; i <= M; i++) {
			int c = in.nextInt();
			if(c == 1) {
				int k = in.nextInt();
				L.add(k);
			}
			else {
				int v = in.nextInt();
				res = d[v];
				for(int x : L) {
					res = Math.min(res, (d[x] + d[v] - 2 * d[lcs(x,v, parentOf)]));
				}
				System.out.println(res);
			}
		}
	}
	static int dist(int from, int to, Edge[] g) {
		int root = from;
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(root);
		Map<Integer, Integer> Dist = new HashMap<Integer, Integer>();
		Dist.put(root, 0);
		boolean[] visited = new boolean[g.length];
		visited[root] = true;
		while(!Q.isEmpty()) {
			int curr = Q.remove();
			if(curr == to) return Dist.get(curr);
			for(Edge e = g[curr]; e != null; e = e.next) {
				if(!visited[e.to]) {
					Q.add(e.to);
					Dist.put(e.to, Dist.get(curr) + 1);
				}
			}
		}
		return -1;
	}
	/* If you have the distance between each node and the root, it's easy
	 * to calculate the distance between any two nodes in a tree.
	 * Let d[v] be the distance from root to node v then
	 * dist(u,v) = d[u] + d[v] - 2d[lcs(u,v).
	 * 
	 */
	static int lcs(int n1, int n2, int[] Parent) {
		int k = n2;
		ArrayList<Integer> ancestors1 = new ArrayList<Integer>();
		ArrayList<Integer> ancestors2 = new ArrayList<Integer>();
		ancestors1.add(n1); //All the ancestors of node 1 up to root.
		ancestors2.add(n2);
		while(n1 != 1) {
			ancestors1.add(Parent[n1]);
			n1 = Parent[n1];
		}
		while(n2 != 1) {
			if(ancestors1.contains(n2)) //If they share the same ancestor than that's the LCS.
				return n2;
			n2 = Parent[n2];
		}
		return 1; //Node 1 is the ancestor of all the nodes in our tree.
	}
}