import java.util.*;
public class Lca {
    public static void dfs(Map<Integer,ArrayList<Integer>>tree,int parent,int child,int depth,int par[][],int lvl[]){
        ArrayList <Integer>temp=tree.get(child);
        par[0][child]=parent;
        lvl[child]=depth;
        for(Integer a:temp){
            if(a==parent)
                continue;
            dfs(tree, child, a, depth+1,par,lvl); 
        }
        
    }
    public static int findLca(int x,int y,int parent[][],int depth[]) {
        int lg;        
        if(depth[x]<depth[y]){
            int temp=x;
            x=y;
            y=temp;
        }
        for(lg=0;(1<<lg)<=depth[x];lg++);
        lg--;
        for(int i=lg;i>=0;i--){
            if(depth[x]-(1<<i)>=depth[y]){
                x=parent[i][x];
            }
        }
        if(x==y)
            return x;
        System.out.println("x= "+x+" y= "+y+"lg= "+lg);
        for(int i=lg;i>=0;i--){
            if( parent[i][x]!=parent[i][y]){
                x=parent[i][x];
                y=parent[i][y];
            }
        }
        return parent[0][x];
    }
    public static void main(String[] args) {
        Map<Integer,ArrayList<Integer>> tree= new HashMap<>();
        for(int i=0;i<9;i++){
            tree.put(i,new ArrayList<Integer>());
        }
        int log_size=(int) (Math.log(9)/Math.log(2));
        int depth[]=new int[9];
        int parent[][]=new int[log_size][9];
        tree.get(0).add(1);

        tree.get(1).add(2);
        tree.get(2).add(1);

        tree.get(1).add(3);
        tree.get(3).add(1);

        tree.get(1).add(4);
        tree.get(4).add(1);

        tree.get(2).add(5);
        tree.get(5).add(2);

        tree.get(2).add(6);
        tree.get(6).add(2);

        tree.get(6).add(8);
        tree.get(8).add(6);

        tree.get(4).add(7);
        tree.get(7).add(4);

        ArrayList <Integer> id= new ArrayList<Integer>();
        for(int i=0;i<log_size;i++)
            Arrays.fill(parent[i], -1);
        dfs(tree, 0, 1, 1,parent,depth);
        System.out.println(Arrays.toString(depth));
        ///building parent array
        for(int i=1;i<log_size;i++){
            for(int j=0;j<9;j++){
                if(parent[i-1][j]==-1){
                    continue;
                }
                parent[i][j]=parent[i-1][parent[i-1][j]];
            }
        }

        for(int i=0;i<log_size;i++){
            System.out.println(Arrays.toString(parent[i]));
        }
        System.out.println(findLca(5, 8, parent, depth));
    }
}
//LCA