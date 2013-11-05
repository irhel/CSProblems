import java.io.*;
import java.util.*;
public class AmusingJoke {
	public static void main(String[] args) {
		String A, B, C;
		Scanner in = new Scanner(System.in);
		A = in.next();
		B = in.next();
		C = in.next();
		String res = (isAnagram(A + B, C)) ? "YES" : "NO";
		System.out.println(res);
	}
	static boolean isAnagram(String A, String C) {
		char[] a = A.toCharArray();
		char[] b = C.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		if(a.length != b.length)
			return false;
		for(int i = 0; i < a.length; i++)
			if(a[i] != b[i])
				return false;
		return true;
	}
}
	