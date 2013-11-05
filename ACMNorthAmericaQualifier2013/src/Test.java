import java.io.*;
import java.util.*;
public class Test {
	static boolean isPrime(int n) {
		if(n < 2)
			return false;
		if(n == 2)
			return true;
		int m = (int)Math.sqrt(n);
		for(int i = 2; i <= m; i++)
			if(n % i == 0)
				return false;
		return true;
	}
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			if(isPrime(n))
				System.out.println("yes");
			else
				System.out.println("no");
		}
		
	}
}
