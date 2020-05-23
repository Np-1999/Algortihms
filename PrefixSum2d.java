import java.util.Arrays;

public class PrefixSum2d {
    public static int[][] PrefixSum2d_calculate(int input[][]){
        int result[][]=new int[input.length][input[0].length];
        result[0][0]=input[0][0];
        for(int i=1;i<input.length;i++)
            result[i][0]=result[i-1][0]+input[i][0];
        for(int j=1;j<input[0].length;j++)
            result[0][j]=result[0][j-1]+input[0][j];
        for(int i=1;i<input.length;i++){
            for(int j=1;j<input[0].length;j++){
                result[i][j]=result[i-1][j]+result[i][j-1]-result[i-1][j-1]+input[i][j];
            }
        }
        for(int i=0;i<input.length;i++)
            System.out.println(Arrays.toString(result[i]));
        return result;
    }
    public static int ResultOfQuery(int prefix_sum_array[][],int input[][],int x1,int y1,int x2,int y2){
        int result=prefix_sum_array[x2][y2];
        if(x1==0 && y1==0)
            return result;
        else if(x1==0){
            result=result-prefix_sum_array[x2][y1-1];
            return result;    
        }
        else if(y1==0){
            result=result-prefix_sum_array[x1-1][y2];
            return result;    
        }
        result=result-prefix_sum_array[x1-1][y2];
        result=result-prefix_sum_array[x2][y1-1]+prefix_sum_array[x1-1][y1-1];
        return result;
    }
    public static void main(String[] args) {
        int input[][]={
            {10,20,30},
            {5,10,20},
            {2,4,6}
        };
        int result[][]=PrefixSum2d_calculate(input);   
        System.out.println(ResultOfQuery(result,input,1,0,2,2 )); 
    }
}