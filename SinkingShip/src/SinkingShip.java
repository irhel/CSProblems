import java.io.*;
import java.util.*;
public class SinkingShip {
	public static List<Item> L = new ArrayList<Item>();
	static class Item implements Comparable<Item>{
		public String name;
		public int rank;
		public Item(String n, int r) {
			name = new String(n);
			rank = r;
		}
		public int compareTo(Item t) {
			return rank - t.rank;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			String name = in.next();
			String rank = in.next();
			int r;
			if(rank.equalsIgnoreCase("rat"))
				r = 1;
			else if(rank.equalsIgnoreCase("woman") || rank.equalsIgnoreCase("child"))
				r = 2;
			else if(rank.equalsIgnoreCase("man"))
				r = 3;
			else
				r = 4;
			L.add(new Item(name, r));
		}
		Collections.sort(L);
		for(Item T : L)
			System.out.println(T.name);
		
	}
	
}