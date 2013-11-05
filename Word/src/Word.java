import java.io.*;
import java.util.*;
public class Word {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.next();
		int n = word.length();
		int l = 0, u = 0;
		for(int i = 0; i < n; i++) {
			if(word.charAt(i) <= 'Z' && word.charAt(i) >= 'A')
				u++;
			else l++;
		}
		word = (u > l) ? word.toUpperCase() : word.toLowerCase();
		System.out.println(word);
	}
}