public class NonStaticBlockExample {

    static  {
        System.out.println("from the static block 1");
    }

    static  {
        System.out.println("from the static block 2");
    }

    {
        System.out.println("from the no static block 1");
    }

    {
        System.out.println("from the no static block 2");
    }

    public NonStaticBlockExample(){
        System.out.println("from constructor");
    }

    public void printBlock(){
        System.out.println("from the instance method");
    }

}
