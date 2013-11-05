import java.util.*;
import java.io.*;
public class A {
	public static void main(String[] args) {
		double tr, te;
		Scanner in = new Scanner(System.in);
		te = in.nextDouble();
		tr = in.nextDouble();
		while(tr != 0.0 && te != 0) {
			double g = tr / te;
			double res = Math.sqrt((1.0 - g * g));
			System.out.printf("%.3f", res);
			te = in.nextDouble();
			tr = in.nextDouble();
		}
		
	}
}