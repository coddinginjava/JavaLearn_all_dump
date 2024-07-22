package Algo.Recursion;

public class Factorial {

    public static void main(String[] args) {

        int n = 4;

        int resFact = fact(n);
        System.out.println("resFact = " + resFact);

        int resFactOpt = factOpt(n,1);
        System.out.println("resFactOpt = " + resFactOpt);
    }

    public static int fact(int n) {
        if (n == 1)
            return 1;

        return n * fact(n - 1);
    }

    public static  int factOpt(int n , int res){
        if(n==1)
            return  res;
        return  factOpt(n-1,n*res);
    }
}
