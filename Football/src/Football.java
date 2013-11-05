import java.util.*;
import java.io.*;
public class Football {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String t1 = "", t2 = "";
		t1 = in.next();
		int s1 = 0, s2 = 0;
		s1++;
		for(int i = 1; i < n; i++) {
			String input = in.next();
			if(input.equalsIgnoreCase(t1))
				s1++;
			else {
				s2++;
				t2 = input;
			}
		}
		String res = (s1 > s2) ? t1 : t2;
		System.out.println(res);
	}
}