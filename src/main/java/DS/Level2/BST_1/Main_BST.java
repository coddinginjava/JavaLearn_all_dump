package DS.Level2.BST_1;

public class Main_BST {

    public static void main(String[] args) {

        BST bst = new BST();

        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(10);
        bst.insert(2);
        bst.insert(0);

//		System.out.println("done");

//		System.out.println(bst.find(8));

//		bst.traverserPretOrder();

//		bst.traverserInOrder();

//		bst.traverserPostOrder();

//		System.out.println(bst.height());

//		System.out.println(bst.BSTMin());

//		System.out.println(bst.Max());

//		BST bst2 = new BST();
//
//		bst2.insert(7);
//		bst2.insert(4);
//		bst2.insert(9);
//		bst2.insert(1);
//		bst2.insert(6);
//		bst2.insert(8);
//		bst2.insert(10);
//		bst2.insert(11);
//		bst2.insert(2);

//		System.out.println(bst.equals(bst2));

//		bst.swapRoot();
//		System.out.println(bst.isBinarySearchTree());

//		System.out.println(bst.getNodeAtDistance(2));


        System.out.println(bst.levelOrderTraversal());


    }
}
