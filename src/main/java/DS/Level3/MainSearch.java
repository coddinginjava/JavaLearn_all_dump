package DS.Level3;

public class MainSearch {
    public static void main(String[] args) {

//~~~~~~~~~~~~~~~~~~~~~linear search~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//
//        Search search = new Search();
//        int[] array = {7,5,3,1,9,4,8};
//
//        int result = search.linearSearch(array,1);
//        System.out.println(result);


//~~~~~~~~~~~~~~~~~~~~~binary search~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~recursion~~~~~~~~~~~~~~~~//

        Search search = new Search();
        int[] array = {2, 3, 5, 6, 8, 9, 10};

//        int result = search.binarySearchRec(array,1);
//        System.out.println(result);

        //~~~~~~~~~~~~~~~~iteration~~~~~~~~~~~~~~~~//

        int result = search.binarySeacrhItr(array, 5);
        System.out.println(result);

    }
}
