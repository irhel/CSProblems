import java.io.*;
import java.util.*;
public class Fours {
	static class Item {
		public int val;
		List<String> steps;
		public Item(int v) {
			val = v;
			steps = new ArrayList<String>();
		}
	}
	public static void main(String[] args) {
		char[]V = {'+', '-', '*'};
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int k = in.nextInt();
			Item root = new Item(4);
			Queue<Item> Q = new LinkedList<Item>();
			Map<Item, Integer> Depth = new HashMap<Item, Integer>();
			Depth.put(root, 0);
			List<String> Result;
			while(!Q.isEmpty()) {
				Item curr = Q.remove();
				if(curr.val == k && Depth.get(root) == 3) {
					Result = new ArrayList<String>(curr.steps);
				}
				for(int ii = 0; ii < V.length; ii++) {
					Item f = new Item(0);
					if(V[ii] == '+') {
						f.val = curr.val + 4;
						f.steps.add(" + 4");
					}
					else if(V[ii] == '-') {
						f.val = curr.val - 4;
						f.steps.add(" - 4");
					}
					else if(V[ii] == '*') {
						f.val = curr.val * 4;
						f.steps.add(" - 4");
					}
				}
			}
			
		}
	}
}