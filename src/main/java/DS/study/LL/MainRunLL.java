package DS.study.LL;

import java.util.Arrays;

public class MainRunLL {

    public static void main(String[] args) {
        LL ll = new LL();

        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);
        ll.addLast(40);

//        ll.reverse();




//        System.out.println(ll.indexOf(40));
//        System.out.println(ll.indexOf(10));
//        System.out.println(ll.indexOf(50));

//        System.out.println(ll.contains(40));
//        System.out.println(ll.contains(10));
//        System.out.println(ll.contains(50));

        System.out.println(Arrays.toString(ll.toArray()));

        System.out.println(ll.getKthNodeFromEnd(45));

//        ll.removeFirst();
//        System.out.println(Arrays.toString(ll.toArray()));

//        ll.removeLast();
//        System.out.println(Arrays.toString(ll.toArray()));
//
//        ll.removeFirst();
//        System.out.println(Arrays.toString(ll.toArray()));
    }
}
