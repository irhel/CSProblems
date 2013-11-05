import java.util.Scanner;

public class Molecules
{
	public static void main(String[] args)
	{
		int A,B,C;
		Scanner in = new Scanner(System.in);
		A = in.nextInt();
		B = in.nextInt();
		C = in.nextInt();
		boolean flag = false;
		int x = 0, y = 0, z = 0;
		x = (A - C + B) / 2;
		if(x * 2 != (A - C + B))
			flag = true;
		y = B - x;
		z = C - y;
		if(x < 0 || y < 0 || z < 0)
			flag = true;
		if(flag)
			System.out.println("Impossible");
		else System.out.println(x + " " + y + " " + z);
		
			
		
	}
}