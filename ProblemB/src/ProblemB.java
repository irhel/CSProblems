import java.util.*;
import java.io.*;
public class ProblemB {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()) {
			int k = in.nextInt();
			for(int j = 0; j < k; j++) {
				int n = in.nextInt();
				//first get it to a string of ones and zeroes
				String A = "";
				String weight = toBase(n);
				for(int i = 0; i < weight.length(); i++)  {
					if(weight.charAt(i) == '2')
						A += "1";
					else A += "0";
				}
				String B = "";
				int carry = 0;
				int len = weight.length();
				
				for(int i = len - 1; i >= 0; i--) {
					int a = Character.getNumericValue(weight.charAt(i));
					int b = Character.getNumericValue(A.charAt(i));
					if(carry + a + b >= 3) {
						B += String.valueOf((carry + a + b) % 3);
						carry = 1;
					}
					else {
						B += String.valueOf(carry + a + b);
						carry = 0;
					}
				}
				if(carry != 0)
					B+="1";
				System.out.print("left pan: ");
				int p = 0;
				for(int i = len - 1; i >= 0; i--) {
					if(A.charAt(i) == '1'){
						System.out.print((int)Math.pow(3, p) + " ");
					}
					p++;
				}
				System.out.println();
				System.out.print("right pan: ");
				p = B.length() - 1;;
				for(int i = B.length() - 1; i >= 0 ; i--) {
					if(B.charAt(i) == '1') {
						System.out.print((int)Math.pow(3, p) + " ");
					}
					p--;
				}
				System.out.println();
			}
		}
	}
	static String toBase(int n) {
		Stack s = new Stack();
		while(n != 0) {
			int r = n % 3;
			s.push(r);
			n /= 3;
		}
		int res = 0;
		int c = 0;
		
		for(int i = 0; i < s.size(); i++) {
			res = res + (int)s.get(i) * (int)Math.pow(10, i);
		}
		return String.valueOf(res);
	}
}