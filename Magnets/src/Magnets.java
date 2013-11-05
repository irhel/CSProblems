import java.util.Scanner;

public class Magnets
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int res = 0;
		int T = in.nextInt();
		res++;
		for(int i = 1; i < N; i++)
		{
			int K = in.nextInt();
			if(T != K)
			{
				res++;
				T = K;
			}
		}
		System.out.println(res);
	}
}