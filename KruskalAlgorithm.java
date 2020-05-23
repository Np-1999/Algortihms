import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class KruskalAlgorithm {
    static class subset{
        int parent,rank;
    }
    static class edge implements Comparable<edge>{
        int from,to,w;
        edge(int from,int to , int w){
            this.from=from;
            this.to=to;
            this.w=w;
        }
        public int compareTo(edge obj){
            return this.w-obj.w;
        }
    }
    public static void KruskalMST(Map<Integer,ArrayList<edge>> graph,int n){
        PriorityQueue <edge> q= new PriorityQueue<>();
        ArrayList <edge> temp;
        edge result[]=new edge[n];
        int e=0;
        for(int i=0;i<n;i++){
            temp=graph.get(i);
            Iterator<edge> j= temp.listIterator();
            while(j.hasNext())
                q.add(j.next());
        }
        subset subsets[]=new subset[n];
        for(int i=0; i<n; ++i) 
            subsets[i]=new subset(); 
        for(int i=0;i<n;i++){
            subsets[i].parent=i;
            subsets[i].rank=0;
        }
        while(!q.isEmpty()){
            edge to_check=q.poll();
            int x=find(subsets,to_check.from);
            int y=find(subsets,to_check.to);
            if(x!=y){
                result[e++]=to_check;
                union(subsets, x, y);
            }
        }
        for(int i=0;i<e;i++){
            System.out.println(result[i].from+" "+result[i].to);
        }
    }
    public static int find(subset subsets[],int i){
        if(subsets[i].parent!=i)
            subsets[i].parent=find(subsets,subsets[i].parent);
        return subsets[i].parent;
    }
    public static void union(subset subsets[],int x,int y){
        int xroot=x;
        int yroot=y;
        if(subsets[xroot].rank<subsets[yroot].rank){
            subsets[xroot].parent=yroot;
            subsets[yroot].rank++;
        }
        else if(subsets[xroot].rank > subsets[yroot].rank){
            subsets[yroot].parent=xroot;
            subsets[xroot].rank++;
        }
        else{
            subsets[yroot].parent=xroot;
            subsets[xroot].rank++;
        }
    }
    public static void main(String[] args) {
        Map<Integer,ArrayList<edge>>graph=new HashMap();
        for(int i=0;i<6;i++)
            graph.put(i,new ArrayList<edge>());
    
        graph.get(0).add(new edge(0,1,3));
        graph.get(0).add(new edge(0,4,5));
        graph.get(1).add(new edge(1,2,5));
        graph.get(1).add(new edge(1,4,6));
        graph.get(2).add(new edge(2,3,9));
        graph.get(2).add(new edge(2,5,3));
        graph.get(3).add(new edge(3,5,7));        
        graph.get(4).add(new edge(4,5,2));

        KruskalMST(graph, 6);
    }   
}