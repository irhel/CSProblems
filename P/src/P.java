import java.util.*;
public class P {
	public static Map<Connection, Integer> M = new HashMap<Connection, Integer>();
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
	public static void main(String[] args) {
		List<Connection> L = new LinkedList<Connection>();
		L.add(new Connection(1,2,4));
		L.add(new Connection(1,2,5));
		L.add(new Connection(1,2,3));
		
		Collections.sort(L);
		
		
		for(Connection C : L)
			System.out.println(C.cost);
	}
}