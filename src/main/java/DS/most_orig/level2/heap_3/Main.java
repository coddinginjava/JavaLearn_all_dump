package DS.most_orig.level2.heap_3;

public class Main {

    public static void main(String[] args) {

        MyHeap heap = new MyHeap();

        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);



        while(!heap.isEmpty()){
            System.out.println(heap.remove());
        }
        /* output
        * 22
        * 17
        * 10
        * 5
        * 4
        * */
////
//        System.out.println(heap.remove()); // 17 5 10 4 - 5 (leave this 5 in the last coz size is 4)
//        System.out.println(heap.remove());
        System.out.println("done");


//          heap sort asscending and decending order

//        int[] number = {5, 3, 10, 1, 4, 2};
//
//        for (int val : number) {
//            heap.insert(val);
//        }
//
//        //for descending order
////        for (int i = 0; i < number.length; i++) {
//        //ascending order
//        for (int i = number.length - 1; i >= 0; i--) {
//            number[i] = heap.remove();
//        }
//
//        System.out.println(level1.Arrays.toString(number));

    }
}
