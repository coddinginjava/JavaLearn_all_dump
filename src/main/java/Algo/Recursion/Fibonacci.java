package Algo.Recursion;

public class Fibonacci {

    public static void main(String[] args) {

        int n = 10;

        int resFibHead = fibHead(n);
        System.out.println("resFibHead = " + resFibHead);

        int resFibTail = fibTail(n, 0, 1);
        System.out.println("resFibTail = " + resFibTail);
    }

    public static int fibHead(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        /*same as
            int res1 = fibHead(n-1);
            int res2 = fibHead(n-2);
            return res1 + res2;
        * */
        return fibHead(n - 1) + fibHead(n - 2);
    }

    public static int fibTail(int n, int a, int b) {
        if (n == 0) return a;
        if (n == 1) return b;
        return fibTail(n - 1, b, a + b);

        /* a b
           0 1
           1 0+1=1
           1 1+1=2
           2 1+2=3
           3 2+3=5
        * */
    }
}
