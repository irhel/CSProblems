import java.io.*;
import java.util.*;
public class Combination {
	static class Card implements Comparable<Card>{
		public int ai;
		public int bi;
		public Card(int a, int b) {
			ai = a;
			bi = b;
		}
		public int compareTo(Card x) {
			int c = x.bi - bi;
			return (c == 0) ? (x.ai - ai) : c;
		}
	}
	public static void main(String[] args) {
		List<Card> list = new ArrayList<Card>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			list.add(new Card(in.nextInt(), in.nextInt()));
		}
		Collections.sort(list);
		int res = list.get(0).ai;
		int counter = list.get(0).bi;
		for(int i = 0; i < counter && i < list.size() - 1; i++) {
			Card C = list.get(i + 1);
			res += C.ai;
			counter = counter + C.bi;
		}
		System.out.println(res);
	}
}