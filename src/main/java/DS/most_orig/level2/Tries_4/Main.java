package DS.most_orig.level2.Tries_4;

public class Main {

    public static void main(String[] args) {
//        MyTriesUsingNode tries = new MyTriesUsingNode();
//        MyTriesUsingHashMap tries = new MyTriesUsingHashMap();
        MyTiresUsingHashMapOptimised tries = new MyTiresUsingHashMapOptimised();
//        tries.insert("cat");
//        tries.insert("can");
//        System.out.println("done");

//        tries.insert("canada");
//        System.out.println(tries.contains("can"));//false
//        System.out.println(tries.contains("canada"));//true

//        tries.traverse();

//        tries.insert("car");
//        tries.insert("care");
//        tries.remove("car");
////        tries.remove("care");
//
//        System.out.println(tries.contains("car"));//false
//        System.out.println(tries.contains("care"));//true


        tries.insert("car");
        tries.insert("card");
        tries.insert("careful");
        tries.insert("egg");
        System.out.println("1" + tries.findWords(null));
        System.out.println("2" + tries.findWords("d"));

        System.out.println("3" + tries.findWords("c"));
        System.out.println("4" + tries.findWords("e"));

        System.out.println("all" + tries.findWords(""));


    }
}
