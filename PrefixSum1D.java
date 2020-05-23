public class PrefixSum1D{
    public static int[] prefixsum(int a[]){
        int prefixsum_result[]=new int[a.length];
        prefixsum_result[0]=a[0];
        for(int i=1;i<a.length;i++){
            prefixsum_result[i]=prefixsum_result[i-1]+a[i];
        }
        return prefixsum_result;
    }
    public static int calculate_sum(int prefixsum_result[],int x,int y){
        return prefixsum_result[y]-prefixsum_result[x-1];
    }
    public static void main(String[] args) {
        int a[]={
            1,3,4,8,6,1,4,2
        };
        int result[]=prefixsum(a);
        int x=3,y=6;
        System.out.println(calculate_sum(result, x, y));
    }
}