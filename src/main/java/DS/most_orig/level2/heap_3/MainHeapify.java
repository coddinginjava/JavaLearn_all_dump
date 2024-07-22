package DS.most_orig.level2.heap_3;

public class MainHeapify {

    public static void main(String[] args) {
        int arr[] = {5, 3, 8, 4, 1, 2, 10};
//         input grap internally
        //          5
        //      3       8
        //   4    1   2    10

        //  output grap internally
        //          10
        //      4       8
        //   3    1   2    5


//        MyHeapify.doHeapify(arr);//[10, 4, 8, 3, 1, 2, 5] (output)

//        System.out.println(level1.Arrays.toString(arr));


        int kth_item = MyHeapify.getKthLargeritem(arr, 2);

        System.out.println("kth_item = " + kth_item);


    }

}
