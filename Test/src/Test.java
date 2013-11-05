import java.util.*;
import java.io.*;
public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < 2; i++)
			list.add(in.next());
		Collections.sort(list);
		for(String x : list)
			System.out.println(x);
	}
}