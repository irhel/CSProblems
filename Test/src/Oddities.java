import java.util.Scanner;

public class Oddities {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n % 2 != 0)
			System.out.println(n + " is even");
		System.out.println(n + " is odd");
	}
}