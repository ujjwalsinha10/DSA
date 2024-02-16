package RecursionAdvanced;

/*
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 */
public class PowXN {
    public static void main(String[] args) {
        double x=2.0;
        int pow=10;
        System.out.println(bruteForceAApproach(x,pow));
        System.out.println(binaryExponentiationApproach(x,pow));
    }

    private static double binaryExponentiationApproach(double x, int pow) {
        double ans=1.0;
        long nn=pow;
        if(nn<0) nn=-1*nn;
        while(nn>0){
            if(nn%2==1){
                ans=ans*x;
                nn=nn-1;
            }else{
                x=x*x;
                nn=nn/2;
            }
        }
        if(pow<0) ans=(double)1.0/(double)ans;
        return ans;
    }

    private static double bruteForceAApproach(double x, int pow) {
        double ans=1.0;
        for(int i=0;i<pow;i++){
            ans=ans*x;
        }
        return ans;
    }
}
