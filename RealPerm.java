import java.util.*;
public class RealPerm {
    static int n=3;
    static List <Integer> k;
    static boolean chosen[];
    public static void search(){
        if(k.size()==n){
            System.out.println(k);
        }
        else{
            for(int i=0;i<n;i++){
                if(chosen[i]==true)
                    continue;
                chosen[i]=true;
                k.add(i);
                search();
                chosen[i]=false;
                k.remove(k.indexOf(i));
            }
        }
    }
    public static void main(String[] args) {
        k=new ArrayList<Integer>();
        chosen=new boolean[n];
        search();
    }
}