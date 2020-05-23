public class EuclidGCD {
    private static int  calulate_gcd(int a,int b){
        if(b==0)
            return a;
        return calulate_gcd(b,a%b);
    }
    public static void main(String[] args) {
        System.out.println(calulate_gcd(12, 30));
    }
}
//lcm can be calculated as a*b/gcd(a,b)
//complexity O(log n)