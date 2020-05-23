import java.util.*;
public class DijsktraS {
    static class edges{
        int from, to, w;
        edges(int from,int to,int w){
            this.from=from;
            this.to=to;
            this.w=w;
        }
    }
    static class entry implements Comparable<entry>{
        int node, value;
        entry(int node,int value){
            this.node=node;
            this.value=value;
        }
        @Override
        public int compareTo(entry other){
            return this.value-other.value;
        }
    }
    public static void dijkstras_algo(Map<Integer,ArrayList<edges>> graph, int s,int n,int path[],PriorityQueue<entry>q) {
        int real_path[]=new int[n];
        int visited[]=new int[n];
        entry temp;
        ArrayList<edges>temp1;
        Arrays.fill(path,Integer.MAX_VALUE);
        path[s]=0;
        q.add(new entry(s,0));
        while(!q.isEmpty()){
            temp=q.poll();
            visited[temp.node]=1;
            temp1=graph.get(temp.node);
            for(edges ed:temp1){
                if(visited[ed.to]==1)
                    continue;
                if(path[ed.to] > path[ed.from]+ed.w){
                    real_path[ed.to]=temp.node;
                    path[ed.to]=path[ed.from]+ed.w;
                    q.add(new entry(ed.to,path[ed.from]+ed.w));
                }
                    
            }

        }
            System.out.println(Arrays.toString(path));
            System.out.println(Arrays.toString(real_path));
    }
    public static void main(String[] args) {
        PriorityQueue<entry> q= new PriorityQueue<>();
        Map<Integer,ArrayList<edges>> graph=new HashMap();
        int path[]=new int[6];
        int s=0;
        int n=6;
        for(int i=0;i<6;i++){
            graph.put(i,new ArrayList<>());
        }
        graph.get(0).add(new edges(0, 1, 3));
        graph.get(0).add(new edges(0,2,2));
        graph.get(1).add(new edges(1, 3, 4));
        graph.get(1).add(new edges(1, 4, 2));
        graph.get(2).add(new edges(2, 4, 7));
        graph.get(2).add(new edges(2, 1, 8));
        graph.get(3).add(new edges(3, 5, 3));
        graph.get(3).add(new edges(3,4,6));
        graph.get(5).add(new edges(5, 5, 1));

      /*  graph.get(0).add(new edges(0, 1, 3));
        graph.get(1).add(new edges(1,0,3));
        graph.get(0).add(new edges(0,2,2));
        graph.get(2).add(new edges(2,0,2));
        graph.get(1).add(new edges(1, 3, 4));
        graph.get(3).add(new edges(3, 1, 4));
        graph.get(1).add(new edges(1, 4, 2));
        graph.get(4).add(new edges(4, 1, 2));
        graph.get(2).add(new edges(2, 4, 7));
        graph.get(4).add(new edges(4, 2, 7));
        graph.get(2).add(new edges(2, 1, 8));
        graph.get(1).add(new edges(1, 2, 8));
        graph.get(3).add(new edges(3, 5, 3));
        graph.get(5).add(new edges(5, 3, 3));
        graph.get(3).add(new edges(3,4,6));
        graph.get(4).add(new edges(4,3,6));
        graph.get(4).add(new edges(4, 5, 1));
        graph.get(5).add(new edges(5, 4, 1));*/
        dijkstras_algo(graph, s, n, path, q);

    }
}
