import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

public class App {

    public static void main(String[] args) {

        /* 1
        checking the output
        double d = 1.0/0.0;
        System.out.println(Double.isInfinite(d));*/


        /*
        2 output is concurrentModificationexception will throw
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        Iterator<Integer> iterator = ls.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            ls.add(5);
        }*/

      /* 3
      String name = getValueFromTryCatch();

        System.out.println("name = " + name);*/

        NonStaticBlockExample blockExample = new NonStaticBlockExample();

        blockExample.printBlock();
    }

    /* 3 if
    private static String getValueFromTryCatch(){
        try{
//            System.exit(0);
            return  "hello world";
        }catch (Exception e){
            return null;
        }finally {
            return "james bound";
//            System.out.println("i am a rock star");
        }
    }*/

}
