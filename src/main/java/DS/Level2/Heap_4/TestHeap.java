package DS.Level2.Heap_4;

import java.util.Arrays;

public class TestHeap {
    public static void main(String[] args) {

        MyHeap heap = new MyHeap();
//


        heap.insert(17);
        heap.insert(5);
        heap.insert(1);
        heap.insert(20);
        heap.insert(9);
        heap.insert(25);


        while(!heap.isEmpty()){
            System.out.println(heap.remove());
        }
//
//        System.out.println("done");
//
//        int arr[] = {5, 3, 8, 4, 1, 2, 10};
//
//        MyHeapify.doHeap(arr);
//        System.out.println(Arrays.toString(arr));
//
//
//        int kth_item = MyHeapify.getKthLargeritem(arr, 2);
//        System.out.println("kth_item = " + kth_item);

    }
}
