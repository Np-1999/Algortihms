import java.util.*;
public class PrimeFactors {
   private static  void PrimeFactors_listC(int no,ArrayList<Integer>factors) {
        for(int i=2;i*i<=no;i++){
            while(no %i==0){
                no /=i;
                factors.add(i);
            }
        }
        if(no>1)
            factors.add(no);    
   } 
   public static void main(String[] args) {
        ArrayList factors=new ArrayList<Integer>();
        PrimeFactors_listC(12,factors);
        System.out.println(factors);
   }
}