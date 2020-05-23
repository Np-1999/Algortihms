import java.util.Arrays;

public class SegmentTreePrefixSum {
    public static int sum(int st[],int x,int y,int n) {
        int sum=0;
        int a=x+n;
        int b=y+n;
        while(a<=b){
            if(a%2==1)
                sum+=st[a++];
            if(b%2==0)
                sum+=st[b--];
            a=a/2;
            b=b/2;
        }
        return sum;
    }
    public static void update(int st[],int val,int index,int n){
        int k=index+n;
        st[k]=val;
        for(k/=2; k>=1;k/=2){
            st[k]= st[2*k]+st[(2*k)+1];
        }
    }
    public static int[] constructSt(int arr[],int n){
        int st[]=new int[2*n];
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
        System.out.println(sum(st,2,7,n));
    }
}