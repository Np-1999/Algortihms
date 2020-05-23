import java.util.Arrays;

public class PrefixSumBinaryIT {
    public static int sumProcessing(int bit[],int i,int j){
        int sum_0b=sum(bit,j);
        int  sum_0a_1=sum(bit,i-1);
        return sum_0b-sum_0a_1;
    }
    public static int sum(int bit[],int index) {
        int sum=0;
        int k=index+1;
        while(k>0){
            sum+=bit[k];
            k -= k & -k;
        }
        return sum;
    }
    public static void update(int bit[],int n,int val,int index) {
        int k=index+1; 
        while(k <= n){
            bit[k] += val;
            k+=(k&-k);
        }
    }
    public static int[] constructBit(int n,int arr[]){
        int bit[]=new int[n+1];
        for(int i=0;i<n;i++){
            update(bit,n,arr[i],i);
        }
        return bit;
    }
    public static void main(String[] args) {
        int arr[]={2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        int n=arr.length;
        int bit[]=constructBit(n, arr);
        System.out.println(Arrays.toString(bit));
        System.out.println(sumProcessing(bit, 3, 5));
    }
}