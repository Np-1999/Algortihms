public class MaxSumArraySubs{
    public static void CalculateSum(int arr[]) {
        int sum=0,best=0;
        for(int i=0;i<arr.length;i++){
            sum=Math.max(arr[i],sum+arr[i]);
            best=Math.max(best,sum);
        }
        System.out.println(best);
    }
    public static void CalculateSum_ncube(int arr[]){
        int sum=0, best=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                best=Math.max(sum,best);
            }
        }
        System.out.println(best);
    }
    public static void CalculateSum_nquad(int arr[]){
        int sum=0,best=0;
        for(int i=0;i<arr.length;i++){
            sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                best=Math.max(sum,best);
            }
        }
        System.out.println(best);
    }
    public static void main(String[] args) {
        int num[]={-1,2,4,-3,5,2,-5,2};
        //CalculateSum(num);
        //CalculateSum_ncube(num);
        CalculateSum_nquad(num);
    }
}