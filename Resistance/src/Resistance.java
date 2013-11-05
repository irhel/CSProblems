import java.util.Scanner;

public class Resistance
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int a,b;
		a = in.nextInt();
		b = in.nextInt();
		int k = 0;
		if(valid(a,b))
			System.out.println(a/b);
		
		else
		{
			while(!valid(a,b))
			{
				k+=2;
				a -= 1;
			}
			System.out.println(a/b + k);
		}
	}
	static boolean valid(int a, int b)
	{
		int res = a / b;
		if(res * b == a)
			return true;
		return false;
	}
}