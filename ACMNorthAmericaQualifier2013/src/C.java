import java.util.*;
import java.io.*;
public class C {
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
		Scanner in = new Scanner(new File("big.in"));
		while(in.hasNext()) {
			int n = in.nextInt();
			List<String> list = new ArrayList<String>();
			int res = 0;
			for(int i = 0; i < n; i++) {
				int k = in.nextInt();
				for(int ii = 2; ii <= k; ii++) {
					for(int jj = ii; jj <= k; jj++) {
						if(ii + jj == k && isPrime(ii) && isPrime(jj)) {
							list.add(new String(ii + "+" + jj));
							res++;
						}
					}
				}
				System.out.println(k + " has " + res + " representation(s)");
				for(String X : list)
					System.out.println(X);
				System.out.println();
				list.clear();
				res = 0;
			}
		}
	}

}
