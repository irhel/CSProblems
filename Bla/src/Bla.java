import java.io.*;
import java.util.*;
public class Bla{
    static class edge implements Comparable<edge>{
        int u;
        int v;
        int w;
        public edge(int st, int end, int we){
            this.u = st;
            this.v = end;
            this.w = we;
        }
        @Override
        public int compareTo(edge o) {
            if(w > o.w)
                return -1;
            else
                return 1;
        }
    }
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
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        PriorityQueue<edge> edgeList = new PriorityQueue<edge>();
        int n,oldCost,k,newCost,counter = 0;
        while(in.hasNext()){
            n = in.nextInt();
            if(counter++ != 0)
                out.append("\n");
            oldCost = 0;
            newCost = 0;
            initSet(n);
            System.out.println("ok");
            for (int i = 0; i < n-1; i++) {
                in.nextInt();
                in.nextInt();
                oldCost += in.nextInt();
            }
            System.out.println("ok");
            k = in.nextInt();
            for (int i = 0; i < k; i++) {
                edge e = new edge(in.nextInt() -1, in.nextInt() -1, -in.nextInt());
                edgeList.add(e);
            }
            System.out.println("ok");
            k = in.nextInt();
            for (int i = 0; i < k; i++) {
                edge e = new edge(in.nextInt() -1, in.nextInt() -1, -in.nextInt());
                edgeList.add(e);
            }
            while(!edgeList.isEmpty()){
                edge e = edgeList.poll();
                if(!isSameSet(e.u, e.v)){
                    newCost += -e.w;
                    unionSet(e.u, e.v);
                }
            }
            out.append(oldCost + "\n" + newCost + "\n");
        }
        System.out.print(out);
    }
}