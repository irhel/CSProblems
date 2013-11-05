import java.util.*;
import java.io.*;
public class ColorfulGraph {
	static class C implements Comparable<C>{
		public int color;
		public int card;
		public C(int c, int ca) {
			color = c;
			card = ca;
		}
		public int compareTo(C x) {
			return x.card - card;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] colors = new int[n + 1];
		for(int i = 0; i < n; i++) {
			colors[i + 1] = in.nextInt();
			map.put(colors[i + 1], new HashSet<Integer>());	
		}
		for(int i = 1; i <= m; i++) {
			int f = in.nextInt();
			int t = in.nextInt();
			int c1 = colors[f];
			int c2 = colors[t];
			if(c1 != c2) {
				map.get(c1).add(c2);
				map.get(c2).add(c1);
			}
		}
		List<C> R = new ArrayList<C>();
		for(Map.Entry<Integer, Set<Integer>> M : map.entrySet()) {
			R.add(new C(M.getKey(), M.getValue().size()));
		}
		Collections.sort(R);
		C k = R.get(0);
		int resColor = k.color;
		int resCardinality = k.card;
		for(C x : R) {
			if(x.card == resCardinality && x.color < resColor) {
				resColor = x.color;
			}
		}
		System.out.println(resColor);
	}
}