import java.util.*;
public class SubstreeSum {
    static class Node{
        int id;
        int value;
        Node(int id,int value){
            this.id=id;
            this.value=value;
        }
    }
    public static int dfs(Map<Integer, ArrayList<Node>>tree,Node parent,Node children,int dp[][],int max_index,int indexes[]){
        int count=1;
        dp[0][max_index]=children.id;
        int index=max_index;
        indexes[children.id]=index;
        ArrayList<Node> temp=tree.get(children.id);
        for(Node a:temp){
            if(a.id==parent.id)
                continue;
            
            int c=dfs(tree, children, a,dp,max_index+1,indexes);
            max_index+=c;
            count+=c;
        }
        dp[1][index]=count;
        dp[2][index]=children.value;
        return count;
    }
    public static int subtreeSum(Node x,int dp[][],int indexes[]){
        
        int count=dp[1][indexes[x.id]];
        int starting_index=indexes[x.id];
        int sum=0;
        for(int i=0;i<count;i++){
            sum+=dp[2][starting_index+i];
            
        }
        return sum;
    }
    public static void main(String[] args) {
        Map<Integer, ArrayList<Node>> tree= new HashMap();
        for(int i=0;i<=9;i++){
            tree.put(i,new ArrayList<Node>());   
        }
        Node[] arr= new Node[10];
        arr[0]=new Node(0,0);
        arr[1]=new Node(1,2);
        arr[2]=new Node(2,3);
        arr[3]=new Node(3,5);
        arr[4]=new Node(4,3);
        arr[5]=new Node(5,1);
        arr[6]=new Node(6,4);
        arr[7]=new Node(7,4);
        arr[8]=new Node(8,3);
        arr[9]=new Node(9,1);
        tree.get(0).add(arr[1]);
        tree.get(1).add(arr[2]);
        tree.get(2).add(arr[1]);
        tree.get(2).add(arr[6]);
        tree.get(6).add(arr[2]);
        tree.get(1).add(arr[3]);
        tree.get(3).add(arr[1]);
        tree.get(1).add(arr[4]);
        tree.get(4).add(arr[1]);
        tree.get(4).add(arr[7]);
        tree.get(7).add(arr[4]);
        tree.get(4).add(arr[8]);
        tree.get(8).add(arr[4]);
        tree.get(4).add(arr[9]);
        tree.get(9).add(arr[4]);
        tree.get(1).add(arr[5]);
        tree.get(5).add(arr[1]);
        int dp[][]=new int[3][10];
        int indexes[]=new int[10];
        dfs(tree,arr[0],arr[1],dp,1,indexes);
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(subtreeSum(arr[4], dp,indexes));
    }
}