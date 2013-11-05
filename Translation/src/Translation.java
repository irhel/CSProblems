import java.io.*;
import java.util.*;
public class Translation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String A = in.next();
		String B = in.next();
		if(A.equalsIgnoreCase(rev(B)))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	static String rev(String B) {
		String f = "";
		for(int i = B.length() - 1; i >= 0; i--)
			f+=B.charAt(i);
		return f;
	}
}