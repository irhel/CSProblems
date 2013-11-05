import java.util.*;
public class Commands {
	public static void main(String[] args) {
		Stack<String> S = new Stack<String>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<String> R = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			String command = in.next();
			if(command.equalsIgnoreCase("pwd")) {
				int size = S.size();
				for(int j = 0; j < size; j++) {
					String x = S.get(j);
					System.out.print("/" + x);
				}
				System.out.println("/");
			
			}
			else {
				String dir = in.next();
				if(dir.charAt(0) == '/')
					S.clear();
				String[] tok = dir.split("/");
				int len = tok.length;
				for(int j = 0; j < len; j++) {
					if(!tok[j].equalsIgnoreCase(""))  {
						if(tok[j].equalsIgnoreCase(".."))
							S.pop();
						else {
							S.push(tok[j]);
						}
					}
				}
			}
			
		}
	}
}