import java.util.Arrays;

public class MinimumQuerySparseTable {
    static class Query 
    { 
	    int L, R; 

	    public Query(int L, int R) 
	    { 
		    this.L = L; 
		    this.R = R; 
	    } 
    }
    public static int[][] preprocessing(int input[]){
        int x=(int)(Math.log(input.length)/Math.log(2))+1;
        System.out.println(x);
        int lookup[][]=new int[input.length][x];
        for(int i=0;i<input.length;i++)
            lookup[i][0]=i;
        
        for(int j=1;(j)<x;j++){
            for(int i=0;(i+(1<<j)-1)<input.length;i++){
                if(input[lookup[i][j-1]]<input[lookup[i+(1<<(j-1))][j-1]]){
                    lookup[i][j]=lookup[i][j-1];
                }
                else{
                    lookup[i][j]=lookup[i+(1<<(j-1))][j-1];
                }
            }
        }
        for(int i=0;i<input.length;i++)
            System.out.println(Arrays.toString(lookup[i]));
        return lookup;
    }
    public static void query_processing(Query q[],int sparse_table[][],int arr[]) {
        for(int i=0;i<q.length;i++){
            int l=q[i].L;
            int r=q[i].R;
            int j=(int)(Math.log(r-l+1)/Math.log(2));
            if(arr[sparse_table[l][j]]<= arr[sparse_table[r-(1<<(j-1))][j]]){
                System.out.println("Minimum of [" + l + ", " + r + 
						"] is " + arr[sparse_table[l][j]]);
            }
            else{
                System.out.println("Minimum of [" + l + ", " + r + "] is " + arr[sparse_table[r-(1<<(j-1))][j]]);
            }
                
        }
    }
    public static void main(String[] args) {
        int arr[]={7, 2, 3, 1, 5, 10, 3, 12, 18};
        Query q[] = {new Query(0, 4), 
            new Query(4, 7), 
            new Query(7, 8)}; 
        int sparse_table[][]=preprocessing(arr);
        query_processing(q,sparse_table,arr);
    }
}