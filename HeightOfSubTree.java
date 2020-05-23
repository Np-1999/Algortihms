import java.util.*;
public class HeightOfSubTree {
    public static void SubtreeHeight(Map<Integer, ArrayList<Integer>> tree,int parent,int child,int count[]) {
        count[child]=0;
        ArrayList <Integer> temp=tree.get(child);
        for(Integer a:temp){
            if(a==parent){
                continue;
            }
            SubtreeHeight(tree,child,a,count);
            count[child]=Math.max(count[child],count[a]+1)   ;
        }
        
    }
    public static void DiameterOfTree(Map<Integer, ArrayList<Integer>> tree,int parent,int child,int count[],int count2[]) {
        int mx1=-1;
        int mx2=-1;
        ArrayList <Integer> temp=tree.get(child);
        for(Integer a:temp){
                
            if(a==parent )
                continue;
            if(count[a]>mx1){
                mx2=mx1;
                mx1= count[a];
            }
            else if(count[a]>mx2){
                mx2=count[a];
            }
        }
        for(Integer a : temp){
            if(a==parent)
                continue;
            int use=mx1;
            if(count[a]==mx1)
                use=mx2;
            count2[a]=Math.max(1+count2[child], 2+use);
            DiameterOfTree(tree, child, a, count, count2);
        }     
    }
    public static void main(String[] args) {
        Map<Integer,ArrayList<Integer>> tree= new HashMap<>();
         for(int i=0;i<7;i++){
             tree.put(i,new ArrayList<Integer>());
         }
         int count[]=new int[7];
         int count2[]=new int[7];
         int dp[]=new int[7];
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
         SubtreeHeight(tree, 0, 0, count);
         DiameterOfTree(tree, 0, 0, count, count2); //We need to call both the functions to get diameter at all node
         for(int i=0;i<7;i++){
            dp[i]=Math.max(count[i],count2[i]);
         }
         System.out.println(Arrays.toString(dp));
         
    }
}