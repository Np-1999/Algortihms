import java.util.*;
public class Ancestor{
    public static void dfs(Map<Integer,ArrayList<Integer>> tree,int parent,int child,int[][] parentArray){
        ArrayList<Integer> temp=tree.get(child);
        for(Integer a: temp){
            if(a==parent)
                continue;
            parentArray[0][a]=child;
            dfs(tree, child, a, parentArray);
        }
    }
    public static void DPbuilder(Map<Integer , ArrayList<Integer>> tree,int parent[][]){
        int n=parent[0].length;
        for(int i=1;i<Math.log(n)/Math.log(2);i++){
            for(int j=0;j<n;j++){
                if(parent[i-1][j]==-1){
                    parent[i][j]=-1;
                    continue;
                }
                    
                parent[i][j]=parent[i-1][parent[i-1][j]];
            }
                
        }
        
    }
    public static int getAncestor(int parent[][], int node , int k) {
        int x=0;
        int j=0;
        while(k>0){
            if ((k&1)!=0){
                node=parent[j][node];
            }
            k=k>>1;
            j++;
        }
        return node;
    }
    public static void main(String[] args) {
        Map<Integer,ArrayList<Integer>> tree= new HashMap<>();
         for(int i=0;i<9;i++){
             tree.put(i,new ArrayList<Integer>());
         }
         int parent[][]=new int[9][9];
         for(int i=0;i<9;i++)
            Arrays.fill(parent[i],-1);
         tree.get(0).add(1);
         tree.get(1).add(0);
         tree.get(1).add(2);
         tree.get(2).add(1);
         tree.get(1).add(6);
         tree.get(6).add(1);
         tree.get(2).add(4);
         tree.get(4).add(2);
         tree.get(2).add(3);
         tree.get(3).add(2);
         tree.get(4).add(5);
         tree.get(5).add(4);
         tree.get(6).add(7);
         tree.get(7).add(6);
         tree.get(5).add(8);
         tree.get(8).add(5);
        dfs(tree, 0, 1, parent);
        DPbuilder(tree, parent);
        for(int i=0;i<Math.log(9)/Math.log(2);i++)
        System.out.println(Arrays.toString(parent[i]));
        System.out.println (getAncestor(parent,8,4));

    }
}