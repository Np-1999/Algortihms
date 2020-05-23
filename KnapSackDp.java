import java.util.Arrays;

public class KnapSackDp {
    public static boolean KnapSack(int k[],int n) {
        boolean possible[][]=new boolean[k.length][n+1];
        possible[0][0]=true;
        for(int i=1;i<k.length;i++){
            for(int j=0;j<=n;j++){
                if(j-k[i]>=0){
                    possible[i][j] |= possible[i-1][j-k[i]];
                }
                possible[i][j] |= possible[i-1][j];
            }
        }
        return possible[k.length-1][n];
    }
    public static void main(String[] args) {
        int k[]={0,1,3,3,4};
        System.out.println(KnapSack(k, 2));
    }
}