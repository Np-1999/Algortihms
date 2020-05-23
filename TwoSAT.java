import java.util.*;
public class TwoSAT {
    static Map<Integer,Boolean > visited;
    static Stack<Integer> dfs_traversal;
    private static void dfs_kosaraju(Map<Integer,ArrayList<Integer>>gt,int root,ArrayList<Integer> print) {
        if(!visited.get(root)){
            visited.put(root,true);
            if(gt.get(root)==null){
                gt.put(root,new ArrayList<Integer>()); //Not supposed to be done like that bt I am lazy
            }
            ArrayList<Integer> temp=gt.get(root);
            for(Integer a:temp){
                if(!visited.get(a)){
                    dfs_kosaraju(gt, a, print);
                }
            }
            print.add(root);
        }
    }
    private static void dfs(Map<Integer, ArrayList<Integer>>graph,int root) {
        if(!visited.get(root)){
            visited.put(root,true);
            ArrayList<Integer> temp=graph.get(root);
            for(Integer a:temp){
                dfs(graph, a);
            }
            dfs_traversal.push(root);
        }
    }
    private static Map<Integer,ArrayList<Integer>> graph_transpose(Map<Integer,ArrayList<Integer>>graph){
        Map<Integer, ArrayList<Integer>> gt=new HashMap();
        for(int i=1;i<=4;i++){
            ArrayList<Integer> temp=graph.get(i);
            for(int a:temp){
                if(gt.get(a)!=null){
                    gt.get(a).add(i);
                }
                else{
                    gt.put(a,new ArrayList<>());
                    gt.get(a).add(i);
                }
            }
        }
        for(int i=-1;i>=-4;i--){
            ArrayList<Integer> temp=graph.get(i);
            for(int a:temp){
                if(gt.get(a)!=null){
                    gt.get(a).add(i);
                }
                else{
                    gt.put(a,new ArrayList<>());
                    gt.get(a).add(i);
                }
            }
        } 
        return gt;
    }
    private static void  createEdge(Map<Integer, ArrayList<Integer>>graph,int a,int b) {
        graph.get(-a).add(b);
        graph.get(-b).add(a);
    }
    
    public static void main(String[] args) {
        dfs_traversal=new Stack();
        visited=new HashMap();
        Map< Integer, ArrayList<Integer>> graph=new HashMap();
        //coding for language (x2 or ~x1) ^ (~x1 or ~x2) ^ (x1 or x3) ^ (~x2 or ~x3) ^ (x1 or x4)
        for(int i=1;i<=4;i++){
            visited.put(i,false);
            visited.put(-i,false);
            graph.put(i,new ArrayList<Integer>());
            graph.put(-i,new ArrayList<Integer>());
        }
        createEdge(graph,2,-1);
        createEdge(graph,-1,-2);
        createEdge(graph,1,3);
        createEdge(graph,-2,-3);
        createEdge(graph,1,4);
        for(int i=1;i<=4;i++){
            System.out.println(i+ "  "+graph.get(i));
            System.out.println(-i+ " "+graph.get(-i));            
        }
        for(int i=1;i<=4;i++){
            dfs(graph, i);
            dfs(graph, -i);

        }
        
        Map<Integer,ArrayList<Integer>> gt=graph_transpose(graph);
        for(int i=1;i<=4;i++){
            System.out.println(i+ "  "+gt.get(i));
            System.out.println(-i+ " "+gt.get(-i));            
        }
        visited=new HashMap();
        for(int i=1;i<=4;i++){
            visited.put(i,false);
            visited.put(-i,false);
        }
        int j=0;
        while(!dfs_traversal.isEmpty()){
            int root=dfs_traversal.pop();
            if(!visited.get(root)){
                ArrayList<Integer>temp=new ArrayList<Integer>();
                dfs_kosaraju(gt, root,temp);
                System.out.println(temp);
                
                for(j=1;j<=4;j++){
                    if(temp.indexOf(j)>-1 && temp.indexOf(-j)>-1){
                        System.out.println("Solution does not exist");
                        break;
                    }
                }
                if(j<5){
                    break;
                }
            }
        }
        if(j==5){
            System.out.println("Solution does exist");
        }
        
    }
}