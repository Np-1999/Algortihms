import java.util.*;
public class SubsetGen{
    static int n=1;
    static List<List<Integer>>ans;
    static List<Integer> k;
    public static void search(int i){
        
        if(i==n+1){
            ans.add(new ArrayList<Integer>(k));
        }
        else{
                k.add(i);
                search(i+1);
                k.remove(k.indexOf(i));
                search(i+1);
        }
    }
    public static void main(String[] args) {
        k=new ArrayList<Integer>();
        ans=new ArrayList<List<Integer>>();  
        search(0);
        System.out.println(ans);
    }
}