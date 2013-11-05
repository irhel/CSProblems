import java.io.*;
import java.util.*;
public class TL {
	public static void main(String[] args) {
		int N, M;
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		int[] A = new int[N];
		int[] B = new int[M];
		for(int i = 0; i < N; i++) 
			A[i] = in.nextInt();
		for(int i = 0; i < M; i++)
			B[i] = in.nextInt();
		int INF = Integer.MAX_VALUE;
		Arrays.sort(A);
		Arrays.sort(B);
		long lo = A[N - 1];
		long hi = B[0] - 1;
		long res = INF;
		int k = 0;
		while(lo <= hi) {
			long mid = lo + (hi - lo)/2;
			if(mid >= 2 * A[0]) {
				res = Math.min(res, mid);
				hi = mid - 1;
			}
			else {
				lo = mid + 1;	
			}
		}
	
		System.out.println(res == INF ? (-1) : res);
		
	}
	
}