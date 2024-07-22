public class TestAApp {
    public static void main(String[] args) {

        int i = 596;
//        int i1 = digSum(i);

        while (i>0){
            i/= 9;
            System.out.println(i);
        }
//        System.out.println("i%9 = " + i%9);

    }

    static int digSum(int n)
    {
        if (n == 0)
            return 0;
        return (n % 9 == 0) ? 9 : (n % 9);
    }
}
