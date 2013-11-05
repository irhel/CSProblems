import java.util.*;
import java.io.*;
public class BuggySorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n == 1 || n == 2)
			System.out.println("-1");
		else {
			for(int i = n; i >= 1; i--) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}