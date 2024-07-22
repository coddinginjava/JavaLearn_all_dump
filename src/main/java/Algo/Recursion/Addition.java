package Algo.Recursion;

public class Addition {

    public static void main(String[] args) {

        int n = 10;

        int resIteration = sumIterative(n);
        System.out.println("resIteration = " + resIteration);

        int resRecursive = sumRecursive(n);
        System.out.println("resRecursive = " + resRecursive);

        int resRecursiveOpt = sumRecursiveOpt(n, 1);
        System.out.println("resRecursiveOpt = " + resRecursiveOpt);

    }

    public static int sumRecursiveOpt(int n, int res) {
        if (n == 1)
            return res;
        return sumRecursiveOpt(n - 1, n + res);
    }

    public static int sumRecursive(int n) {
        if (n == 1)
            return 1;
        return n + sumRecursive(n - 1);
    }

    public static int sumIterative(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++)
            res += i;

        return res;
    }
}


