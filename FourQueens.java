
public class FourQueens {
    static int n=4;
    static int count=0;
    static boolean cols[];
    static boolean diag1[];
    static boolean diag2[];
    public static void count_ways(int y){
        if(y==n){
            count++;
        }
        else{
            for(int i=0;i<n;i++){
                if(cols[i]||diag1[i+y]||diag2[i-y+n-1]){
                    continue;
                }
                cols[i]=diag1[i+y]=diag2[i-y+n-1]=true;
                count_ways(y+1);
                cols[i]=diag1[i+y]=diag2[i-y+n-1]=false;
            }
        }
    }
    public static void main(String[] args) {
        cols=new boolean[n];
        int diag_size= (2*n)-1;
        diag1=new boolean[diag_size];
        diag2=new boolean[diag_size];
        count_ways(0);
        System.out.println(count);
    }
}