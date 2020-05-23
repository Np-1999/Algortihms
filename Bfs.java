import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void Bfs_function(int visited[],ArrayList <ArrayList <Integer>> graph,int start,Queue <Integer> q){
        if(visited[start]==0){
            System.out.println(start);
            visited[start]=1;
            Iterator <Integer> i= graph.get(start).listIterator();
            while(i.hasNext()){
               q.add(i.next());
            }
            while(q.size()!=0){
                int n=q.poll();
                if(visited[n]==0){
                    Bfs_function(visited, graph, n, q);
                }
            }
        }
    }
    public static void main(String[] args) {
        int visited[]=new int[5];
        Queue <Integer> q =new LinkedList<>();
        ArrayList<ArrayList <Integer>> graph=new ArrayList<>(5);
        for(int i=0;i<5;i++)
            graph.add(new ArrayList<Integer>());
        graph.get(0).add(1);
        graph.get(0).add(3);
        graph.get(1).add(2);
        graph.get(1).add(4);
        graph.get(2).add(4);
        Bfs_function(visited, graph, 0, q);
    }
}