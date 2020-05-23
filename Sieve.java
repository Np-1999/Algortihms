import java.util.*;
public class Sieve {
    private static int[] SieveMaking(int no){
        int arr[]=new int[no+1];
        for(int i=2;i<no;i++){
            if(arr[i]==1)
                continue;
            for(int j=i*2;j<=no;j+=i){
                arr[j]=1;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(SieveMaking(20)));
    }
}