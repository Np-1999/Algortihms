import  java.util.*;
public class PermutationProblem {
    static int n=10;
    static boolean visited[];
    static List<Integer>k;
    public static void print_permutation(){
        if(k.size()==n){
            System.out.println(k);
        }else{
            for(int i=1;i<=n;i++){
                if(k.size()>0){
                    if(k.get(k.size()-1)== i-1 ||k.get(k.size()-1)== i+1 ){
                        continue;
                    }
                }
                if(visited[i]==true)
                    continue;
                visited[i]=true;
                k.add(i);
                print_permutation();
                visited[i]=false;
                k.remove(k.indexOf(i));

            }
        }
    }
    public static void main(String[] args) {
        visited=new boolean[n+1];
        k= new ArrayList<Integer>();
        print_permutation();
    }
}