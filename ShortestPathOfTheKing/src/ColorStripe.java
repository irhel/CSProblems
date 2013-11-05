import java.util.*;
import java.io.*;

public class ColorStripe {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		int n, k;
		n = in.nextInt();
		k = in.nextInt();
		String a = in.next();
		char[] b = a.toCharArray();
	
		Arrays.sort(b);
		list.add(Character.toString(b[0]));
		for(int i = 0; i < n - 1; i++) {
			if(b[i] != b[i + 1])
				list.add(Character.toString(b[i+1]));
		}
		while(list.size() < k) {
			char elem = list.get(list.size() - 1).charAt(0);
			char next = (char)(elem + 1);
			list.add(Character.toString(next));
		}
		if(k == 2) {
			char[] st = a.toCharArray();
		}
	}
}