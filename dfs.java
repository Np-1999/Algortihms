import java.util.*;
public class dfs{
    public static void dfs_function(LinkedList <Integer> graph[],int visited[],int s){
        if(visited[s]==0){
            System.out.println(s);
            visited[s]=1;
            Iterator<Integer> i= graph[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(visited[n]==0)
                    dfs_function(graph,visited,n);
            }
        }
            

    }
    public static void main(String[] args) {
        LinkedList <Integer> graph[];
        graph=new LinkedList[5];
        for(int i=0;i<5;i++){
            graph[i]=new LinkedList<>();
        }
        int visited[]=new int[5];
        graph[0].add(1);
        graph[0].add(3);
        graph[1].add(2);
        graph[1].add(4);
        graph[2].add(4);
        dfs_function(graph,visited,0);
    }
}
/* Alternate Arraylist repersentation
 ArrayList<ArrayList<Integer> > adj  
                    = new ArrayList<ArrayList<Integer> >(V); 
          
        for (int i = 0; i < V; i++) 
            adj.add(new ArrayList<Integer>()); 
  
        // Adding edges one by one 
        addEdge(adj, 0, 1); 
        addEdge(adj, 0, 4); 
        addEdge(adj, 1, 2); 
        addEdge(adj, 1, 3); 
        addEdge(adj, 1, 4); 
        addEdge(adj, 2, 3); 
        addEdge(adj, 3, 4); 
   static void addEdge(ArrayList<ArrayList<Integer> > adj, 
                        int u, int v) 
    { 
        adj.get(u).add(v); 
        adj.get(v).add(u); 
    }         
*/