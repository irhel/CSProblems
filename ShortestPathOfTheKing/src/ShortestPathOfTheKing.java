import java.util.*;
import java.io.*;
public class ShortestPathOfTheKing {
	static class Cell {
		public int x;
		public int y;
		List<String> M = new ArrayList<String>();
		public Cell(int x1, int y2, List<String> z) {
			x = x1;
			y = y2;
			M = z;
		}
	}
	public static void main(String[] args) {
		int xs = 0, ys = 0;
		Scanner in = new Scanner(System.in);
		String source = in.next();
		String dest = in.next();
		int xd = 0, yd = 0;
		xs = source.charAt(1) - '1' + 1;
		ys = source.charAt(0) - 'a' + 1;
		xd = dest.charAt(1) - '1' + 1;
		yd = dest.charAt(0) - 'a' + 1;
		boolean[][] Maze = new boolean[9][9];
		Queue<Cell> States = new LinkedList<Cell>();
		List<String> currPath = new ArrayList<String>();
		Cell Root = new Cell(xs, ys, currPath);
		Map<Cell, Integer> Depth = new HashMap<Cell, Integer>();
		States.add(Root);
		Depth.put(Root, 0);
		List<String> res = new ArrayList<String>();
		while(!States.isEmpty()) {
			Cell curr = States.remove();
			int parentDepth = Depth.get(curr);
			int currentDepth = parentDepth + 1;
			if(curr.x == xd && curr.y == yd) {
				res = new ArrayList<String>(curr.M);
				break;
			}
			int[] dx = {0, 0, 0, -1, 1, 1, 1, -1, -1};
			int[] dy = {0, 1, -1, 0, 0, 1, -1, 1, -1};
			String[] Moves = {"", "R", "L", "D", "U", "RU", "LU", "RD", "LD"};
			for(int i = 1; i <= 8; i++) {
				int px = curr.x + dx[i];
				int py = curr.y + dy[i];
				String dir = Moves[i];
				if(px >= 1 && px <= 8) {
					if(py >= 1 && py <= 8) {
						if(!Maze[px][py]) {
							Maze[px][py] = true;
							currPath = new ArrayList<String>(curr.M);
							currPath.add(dir);
							Cell newCell = new Cell(px, py, currPath);
							States.add(newCell);
							Depth.put(newCell, currentDepth);
						}
					}
				}
			}
		}
		System.out.println(res.size());
		for(String X : res)
			System.out.println(X);
	}
}