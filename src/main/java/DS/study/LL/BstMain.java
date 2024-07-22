package DS.study.LL;

public class BstMain {
    public static void main(String[] args) {
        Bst bst = new Bst();

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

//		System.out.println(bst.find(3));

//		bst.traverserPreOrder();

//		bst.traverserInOrder();

//		bst.traverserPostOrder();

//		System.out.println(bst.height());

//		System.out.println(bst.BSTMin());

//		System.out.println(bst.Max());

		Bst bst2 = new Bst();

        bst2.insert(7);
        bst2.insert(4);
        bst2.insert(9);
        bst2.insert(1);
        bst2.insert(6);
        bst2.insert(8);
        bst2.insert(10);
        bst2.insert(2);
        bst2.insert(0);

        System.out.println(bst.height());

//		System.out.println(bst.equals(bst2));

//		bst.swapRoot();
//		System.out.println(bst.isBinarySearchTree());

//		System.out.println(bst.getNodeAtDistance(1));


        System.out.println();
        bst.levelOrderTraversal();
    }
}
