package DS.most_orig.level1.LinkedList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addFirst(50);

//        list.removeFirst();;

//        list.removeLast();

//        list.reverse();

        System.out.println(list.getKnodefromEnd(3));

        System.out.println(Arrays.toString(list.toArray()));

//        System.out.println(list.contains(120));

    }


}
