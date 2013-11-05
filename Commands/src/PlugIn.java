import java.util.*;
import java.io.*;
public class PlugIn {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		List<Character> r = new ArrayList<Character>();
		int n = s.length();
		char[] a = s.toCharArray();
		r.add(a[0]);
		int size = 1;
		for(int i = 1; i < n; i++) {
			if(size > 0 && a[i] == r.get(size - 1)) {
				r.remove(size - 1);
				size--;
			}
			else {
				r.add(a[i]);
				size++;
			}
		}
		for(Character c : r)
			System.out.print(c);
		System.out.println();
	}
}