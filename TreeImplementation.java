import java.util.*;
public class TreeImplementation {

    public static int[] dfs_traversal(int count[],Map <Integer,ArrayList<Integer>> tree,int n,int node,int root){
        System.out.println(node);
        count[node]=1;
        ArrayList<Integer> temp = tree.get(node);
        for(  Integer a:temp){
            if (a==root)
                continue;
            dfs_traversal(count,tree,n,a,node);
            count[node]+=count[a];
        }
        return count;
    }
    public static void main(String[] args) {
         Map<Integer,ArrayList<Integer>> tree= new HashMap<>();
         for(int i=0;i<7;i++){
             tree.put(i,new ArrayList<Integer>());
         }
         int count[]=new int[7];
         tree.get(0).add(1);
         tree.get(1).add(0);
         tree.get(0).add(2);
         tree.get(2).add(0);
         tree.get(1).add(3);
         tree.get(3).add(1);
         tree.get(1).add(4);
         tree.get(4).add(1);
         tree.get(2).add(6);
         tree.get(6).add(2);
         tree.get(4).add(5);
         tree.get(5).add(4);
         count=dfs_traversal(count,tree,7,0,0);
         System.out.println(Arrays.toString(count));
        }
}