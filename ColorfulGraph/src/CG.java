import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class CG {
    private static Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of vertices
        int m = sc.nextInt(); // number of edges

        int colors[] = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
            map.put(colors[i], new HashSet<Integer>());
        }

        for (int k = 0; k < m; k++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            if (colors[a] != colors[b]) {
                map.get(colors[a]).add(colors[b]);
                map.get(colors[b]).add(colors[a]);
            }
        }

        int minColor = Integer.MAX_VALUE;
        int card = Integer.MIN_VALUE;
        for (Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            if (card < size) {
                card = size;
                minColor = entry.getKey();
            } else if (card == size) {
                Integer color = entry.getKey();
                if (minColor > color)
                    minColor = color;
            }
        }

        if (card == 0) {
            System.out.println(Collections.min(map.keySet()));
        } else {
            System.out.println(minColor);
        }
    }
}