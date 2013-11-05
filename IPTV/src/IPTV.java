import java.util.*;
import java.io.*;
public class IPTV {
   static int [] pset;
   static int findSet(int i){
      return (pset[i] == i) ? i : (pset[i] = findSet(pset[i]));
   }
   static void unionSet(int i, int j){
      pset[findSet(i)] = pset[findSet(j)];
   }
   static boolean isSameSet(int i, int j){
      return findSet(i) == findSet(j); 
   }
   private static void initSet(int _size) { 
      pset = new int[_size]; for (int i = 0; i < _size; i++) pset[i] = i; 
   }
   public static Set<String> Names = new LinkedHashSet<String>();
   static class Connection implements Comparable<Connection>{
      public String from, to;
      public int cost;
      public Connection(String f, String t, int c) {
         from = f;
         to = t;
         cost = c;
      }
      public int compareTo(Connection C) {
         return cost - C.cost;
      }
   }
   static int getRes(List<Connection> L, int n) {

      int res = 0;
      initSet(n + 1);
      Collections.sort(L);
      for(Connection C : L) { 
         String from = C.from;
         String to = C.to;
         int n1 = getIndex(from);
         int n2 = getIndex(to);
         if(!isSameSet(n1, n2)) {
            res+=C.cost;
            unionSet(n1, n2);
         }
      }
      return res;
   }
   static int getIndex(String A) {
      int k = 0;
      for(String X : Names) {
         if(X.equalsIgnoreCase(A))
            return k;
         k++;
      }
      return 0;
   }
   public static void main(String[] args) throws IOException {
      int n, m;
      int res = 0;
      int k = 0;
      Scanner in = new Scanner(System.in);
      while(in != null) {

         int t = in.nextInt();
         for(int i = 0; i < t; i++) {
            res = 0;
            Names.add(" ");
            List<Connection> L = new ArrayList<Connection>();
            String blank = in.nextLine();
            n = in.nextInt();
            m = in.nextInt();
            for(int j = 0; j < m; j++) {
               String from = in.next();
               String to = in.next();
               int cost = in.nextInt();
               Names.add(from);
               Names.add(to);
               L.add(new Connection(from, to, cost));
            }
            k++;
            
            	
            res = getRes(L, n);
            System.out.print(res);
            if(t != k)
            	System.out.println();
            L.clear();
            Names.clear();
         }
         k = 0;
      }
      System.exit(0);
   }
}