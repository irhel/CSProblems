import java.util.*;
public class ConvertibleStrings {

	public int leastRemovals(String A, String B) {
		System.out.println(conv("ABCA", "FBGF"));
		return 0;
	}
	static boolean conv(String A, String B) {
		int len = A.length();
		String T1 = new String(A);
		String T2 = new String(B);
		for(int i = 0; i < len; i++) {
			T1 = new String(T1.replaceAll(Character.toString(A.charAt(i)), ""));
			T2 = new String(T2.replaceAll(Character.toString(A.charAt(i)), ""));
			if(T1.length() != T2.length())
				return false;
		}
		if(T1.equalsIgnoreCase(T2))
			return true;
		return false;
	}
}
