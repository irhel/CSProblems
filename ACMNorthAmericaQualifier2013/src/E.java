import java.io.*;
import java.util.*;
public class E {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int k = in.nextInt();
			char[]path = new char[k];
			for(int ii = 0; ii < k; ii++)
				path[ii] = in.next().charAt(0);
			int res = 0;
			int se, ss, sn, sw;
			se = 0; 
			ss = 0;
			sn = 0;
			sw = 0;
			res = path.length;
			
			for(int jj = 0; jj < k; jj++) {
				if(path[jj] == 'S')
					ss++;
				else if(path[jj] == 'E')
					se++;
				else if(path[jj] == 'W')
					sw++;
				else 
					sn++;
			}
			res = Math.abs(sn - ss) + Math.abs(se - sw);
			System.out.println(res);
		}
	}
}