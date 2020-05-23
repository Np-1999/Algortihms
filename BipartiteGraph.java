import java.util.*;
public class BipartiteGraph {
    public static boolean dfs(ArrayList<ArrayList <Integer>> graph,int visited[],int start,int col[],int color) {
        if(visited[start]==0){
            visited[start]=1;
            col[start]=color;
            Iterator <Integer> i= graph.get(start).listIterator();
            while(i.hasNext()){
                int n=i.next();
                    if(visited[n]==0){
                        if(!dfs(graph, visited, n, col, color^1)){
                            return false;
                        }
                    }      
                    else{
                        if(col[start]==col[n])
                            return false;
                    }
                }

        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList <ArrayList <Integer> > graph= new ArrayList(5);
        int visited[]=new int[5];
        int col[]=new int[5];
        Arrays.fill(col, -1);
        for(int i=0;i<5;i++){
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(3);
        graph.get(3).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(4);
        graph.get(4).add(2);
        System.out.println(dfs(graph,visited,0,col,0));
    }
}