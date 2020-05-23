import java.util.Arrays;

public class FloydWarshall{
    
    
        public static void fwarshall(int graph[][]) {
            int dis[][]=graph;
            for(int i=0;i<dis[0].length;i++){
                for(int j=0;j<dis[0].length;j++){
                    for(int k=0;k<dis[0].length;k++){
                        dis[j][k]=Math.min(dis[j][k], dis[j][i]+dis[k][i]);
                    }
                    
                }
                for(int z=0;z<dis.length;z++)
                        System.out.println(Arrays.toString(dis[z]));
                    System.out.println("done");
            }
            for(int i=0;i<dis.length;i++)
                System.out.println(Arrays.toString(dis[i]));
       }    
    public static void main(String[] args) {
        int graph[][]={{0,5,9999999, 9, 1 },
        {5,0,2,9999999,9999999},
        {9999999,2,0,7,9999999},
        {9,9999999,7,0,2},
        {1,9999999,9999999,2,0}
        };
        fwarshall(graph);
    }
}