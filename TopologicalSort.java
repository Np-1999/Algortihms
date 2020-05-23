import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    public static void topological(LinkedList<Integer> graph[],int visited[], int start) {
        Stack <Integer> s=new Stack<Integer>();
        int processing[]=new int[visited.length];
        for(int i=0;i<visited.length;i++)
            if(visited[i]==0)
                topologicalSortUtil(graph, visited, i,s,processing);
        System.out.println(s);
    }
    public static void topologicalSortUtil(LinkedList<Integer> graph[],int visited[],int start,Stack<Integer> s,int processing[]) {
        visited[start]=1;
        processing[start]=1;
        Iterator <Integer> temp = graph[start].listIterator();
        while(temp.hasNext()){
            int i=temp.next();
            if(processing[i]==1){
                System.out.println("cycle exist");
            }
            if(visited[i]==0){
                processing[i]=1;
                topologicalSortUtil(graph, visited, i, s,processing);
            }
        }               
        Arrays.fill(processing, 0);
        s.push(start);
    }

    public static void main(String[] args) {
        LinkedList <Integer> graph[];
        graph=new LinkedList[6];
        for(int i=0;i<6;i++){
            graph[i]=new LinkedList<>();
        }
        int visited[]=new int[6];
        graph[5].add(2);
        graph[5].add(0);
        graph[4].add(0);
        graph[4].add(1);
        graph[2].add(3);
        graph[3].add(1);
        topological(graph,visited,0);
    }
}