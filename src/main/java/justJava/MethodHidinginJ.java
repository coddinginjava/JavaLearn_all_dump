package justJava;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodHidinginJ {

    public static void main(String[] args) {

        String input = "Java articles are Awesome";

        Map<Character, Long> collected = input.chars()
                .mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        TreeMap<Long, List<Character>> collect = collected.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.groupingBy(Map.Entry::getValue, TreeMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));


        System.out.println(collect);


//        Child c = new Child();
//        c.display();
//        c.print();
//        Child.print();
//
//        System.out.println("--------");
//
//        Parent p = new Child();
//        p.display();
//        p.print();
//        Parent.print();
    }
}

class Parent{
    public void display(){
        System.out.println("Parent display");
    }

    public static void print(){
        System.out.println("Parent print");
    }
}

class Child extends Parent {
    public void display(){
        System.out.println("Child display");
    }

    public static void print(){
        System.out.println("Child print");
    }

}