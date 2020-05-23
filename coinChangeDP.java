
public class coinChangeDP {
    static int coins[]={4,3,2};
    static int possibleways(int n){
        int count[]=new int[n+1];
        count[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    count[i]+=count[i-coins[j]];
                }
            }
        }
        return count[n];
    }
    static int LeastNoOfCoins(int n){
        int value[]=new int[n+1];
        int first[]= new int[n+1];
        value[0]=0;
        for(int i=1;i<=n;i++){
            value[i]=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && value[i-coins[j]]+1 < value[i]){
                    value[i]=value[i-(coins[j])]+1;
                    first[i]=coins[j];
                }
                    
            }
        }
        int m=n;
        while(m>0){ //code to print coins
            System.out.println(first[m]);
            m-=first[m];
        }
        return value[n];
    }
    public static void main(String[] args) {
        //System.out.println(LeastNoOfCoins(10));
        System.out.println(possibleways(5));
    }
}