import java.util.*;
public class BellmanFord {
    static class edge{
        int from, to, w;
        edge(int from,int to,int w){
            this.from=from;
            this.to=to;
            this.w=w;
        }
    }
     public static void bellManFord(Map<Integer,ArrayList<edge>> graph,int e,int v) {
        int distance[]=new int[v];
        Arrays.fill(distance,Integer.MAX_VALUE);
        List<edge>temp;
        distance[0]=0;
        System.out.println("Intial " +Arrays.toString(distance) );
            for(int j=0;j<v;j++){
                temp=graph.get(j);
                for(edge ed:temp){
                    if(distance[ed.from]+ed.w < distance[ed.to])
                        distance[ed.to]=ed.from+ed.w;
                }
            }
            
        System.out.println(Arrays.toString(distance));
        for(int j=0;j<v;j++){
            temp=graph.get(j);
            for(edge ed:temp){
                if(distance[ed.from]+ed.w < distance[ed.to])
                    System.out.println("Negative cycle");
            }
        }
        System.out.println(Arrays.toString(distance));
    }
    public static void main(String[] args) {
        Map<Integer,ArrayList<edge>> graph= new HashMap<>();
        for(int i=0;i<9;i++){
            graph.put(i, new ArrayList<>());
        }
        graph.get(0).add(new edge(0, 1, 1));
        graph.get(1).add(new edge(1, 0, 1));
        graph.get(1).add(new edge(1, 2, 1));
        graph.get(2).add(new edge(2, 1, 1));
        graph.get(2).add(new edge(2, 4, 1));
        graph.get(4).add(new edge(4, 2, 1));
        graph.get(4).add(new edge(4, 3, 3));
        graph.get(3).add(new edge(3, 4, 3));
        graph.get(3).add(new edge(3, 2, 1));
        graph.get(2).add(new edge(2, 3, 1));
        graph.get(1).add(new edge(1, 5, 4));
        graph.get(5).add(new edge(5, 1, 4));
        graph.get(1).add(new edge(1, 6, 4));
        graph.get(6).add(new edge(6, 1, 4));
        graph.get(6).add(new edge(6, 7, 4));
        graph.get(7).add(new edge(7, 6, 4));    
        graph.get(5).add(new edge(5, 6, 4));
        graph.get(6).add(new edge(6, 5, 4));
        graph.get(5).add(new edge(5, 7, 3));
        graph.get(7).add(new edge(7, 5, 3));
        bellManFord(graph, 10, 9);
    }
}