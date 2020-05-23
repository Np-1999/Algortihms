public class PrimeNumber {
   public static boolean Is_prime(int no){
       if(no<2){
           return false;
       }
       for(int i=2;i*i<=no;i++){
            if(no%i==0)
                return false;
       }
       return true;
 
    } 
    public static void main(String[] args) {
        System.out.println(Is_prime(4));
    }
}