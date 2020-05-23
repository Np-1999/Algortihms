import java.util.*;
public class KosarRaju {
    static int visited[];
    private static void dfs(ArrayList<ArrayList<Integer>> graph,int root,Stack<Integer>reversdfs) {
        if(visited[root]==0){
            visited[root]=1;
            ArrayList<Integer>temp=graph.get(root);
            for(Integer a:temp){
                if(visited[a]==1)
                    continue;
                dfs(graph,a,reversdfs);
            }
            reversdfs.push(root);
        }
    }
    private static void dfs_kosaraju(ArrayList<ArrayList<Integer>>graph_t,int root,ArrayList<Integer> printing_Strong){
        if(visited[root]==0){
            visited[root]=1;
            ArrayList<Integer> temp=graph_t.get(root);
            for(int a:temp){
                if(visited[a]==0){
                    dfs_kosaraju(graph_t, a, printing_Strong);
                }
            }
            printing_Strong.add(root);
        }
        
    }
    private static ArrayList<ArrayList<Integer>> graph_transpose(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<ArrayList<Integer>> graph_t=new ArrayList<>();
        ArrayList<Integer> temp;
        for(int i=0;i<graph.size();i++){
            graph_t.add(new ArrayList<Integer>());
        }
        for(int i=1;i<graph.size();i++){
            temp=graph.get(i);
            for(int a:temp){
                graph_t.get(a).add(i);
            }
        }
        return graph_t;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList <Integer>> graph=new ArrayList<>();
              
        visited=new int[8];
        for(int i=0;i<8;i++)
            graph.add(new ArrayList<Integer>());
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(3).add(2);
        graph.get(2).add(5);
        graph.get(5).add(4);
        graph.get(1).add(4);
        graph.get(6).add(5);
        graph.get(7).add(6);
        graph.get(3).add(7);
        graph.get(6).add(3);
        Stack<Integer>reversdfs=new Stack();
        for(int i=1;i<8;i++)
            dfs(graph, i, reversdfs);
        ArrayList<ArrayList<Integer>>gt=graph_transpose(graph);
        visited=new int[8];
        while(!reversdfs.isEmpty()){
            int root=reversdfs.pop();
            if(visited[root]==0){
                ArrayList<Integer> temp=new ArrayList<>();
                dfs_kosaraju(gt, root,temp);
                System.out.println(temp);
            }
        }
    }
}