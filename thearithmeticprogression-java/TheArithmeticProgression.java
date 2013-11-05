public class TheArithmeticProgression {

	public double minimumChange(int a, int b, int c) {
		if((b - a) == (c - b))
			return 0.0;
		int aa = Math.abs(b - a);
		int ba = Math.abs(c - b);
		return (double)(Math.abs(aa + ba) / 2.0);
	}

}
