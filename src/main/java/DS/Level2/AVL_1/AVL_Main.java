package DS.Level2.AVL_1;

public class AVL_Main {

    public static void main(String[] args) {

        AVL tree = new AVL();

//        tree.insert(7);
//        tree.insert(4);
//        tree.insert(9);
//        tree.insert(1);
//        tree.insert(6);
//        tree.insert(8);
//        tree.insert(10);
//        tree.insert(2);
//
//        /*case 1*/
        tree.insert(30);
        tree.insert(10);
        tree.insert(20);

//        /*case 2*/
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(25);

        /*case 3*/
//        tree.insert(1);
//        tree.insert(2);
//        tree.insert(3);
//        tree.insert(4);
//        tree.insert(5);

        /*output for above 1,2,3,4,5
         *         2
         *      1     4
         *          3    5
         * */


        /*case 4*/
//        tree.insert(5);
//        tree.insert(10);
//        tree.insert(3);
//        tree.insert(12);
//        tree.insert(15);
//        tree.insert(14);


        /*output for above 5,10,3,12,15,14
         *           12
         *      5         15
         *    3   10   14
         * */


        /*case 5*/
//        tree.insert(12);
//        tree.insert(3);
//        tree.insert(9);
//        tree.insert(4);
//        tree.insert(6);
//        tree.insert(2);


        /*output for above 12,3,9,4,6,2
         *           4
         *      3         9
         *    2         6   12
         * */



        System.out.println("done");


//        System.out.println("tree.isbalanced() = " + tree.isbalanced());



    }
}