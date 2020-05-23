import java.util.*;
public class longestNonDecreasingSequence {
    public static int longestSequence(int arr[] ){
        int value[]=new int[arr.length];
        List <Integer> a=new ArrayList<>();
        int best=1,sequence=0,best_index=0;
        for(int i=0;i<arr.length;i++){
            value[i]=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]<arr[i] && (value[j]+1 > value[i])){
                    value[i]=value[j]+1;
                    sequence=arr[j];
                }
            }
            if(best < value[i]){
                best=value[i];
                best_index=i;
                a.add(sequence);
            }
            
        }
        a.add(arr[best_index]);
        System.out.println(a);
        return best;
    }
    public static void main(String[] args) {
        int arr[]={6,2,5,1,7,4,8,3};
        System.out.println(longestSequence(arr));
    }
}