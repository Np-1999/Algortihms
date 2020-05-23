import java.util.Arrays;
public class SementTreeRangeMinimum {
    public static int smallest(int st[],int x,int y,int n) {
        int a=x+n;
        int b=y+n;
        int smallest=st[a];
        while(a<=b){
            if(a%2==1){
                if(smallest>st[a]){
                    smallest=st[a];
                }
                a++;
            } 
            if(b%2==0){
                if(smallest>st[b]){
                    smallest=st[b];
                }
                b--;
            }
            a=a/2;
            b=b/2;
        }
        return smallest;
    }
    public static void update(int st[],int val,int index,int n){
        int k=index+n;
        
        st[k]=val;
        for(k/=2; k>=1;k/=2){
            if(st[k]>st[2*k] && st[2*k]<st[2*k+1]){
                st[k]=st[2*k];
            }
            if(st[k]>st[2*k+1]){
                st[k]=st[2*k+1];
            }
            
        }
    }
    public static int[] constructSt(int arr[],int n){
        int st[]=new int[2*n];
        Arrays.fill(st,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            update(st,arr[i],i,n);
        }
        System.out.println(Arrays.toString(st));
        return st;
    }
    public static void main(String[] args) {
        int arr[]={5,8,6,3,2,7,2,6};
        int n=arr.length;
        int st[]=constructSt(arr, n);
        System.out.println(smallest(st, 0, 7, n));
   }
}