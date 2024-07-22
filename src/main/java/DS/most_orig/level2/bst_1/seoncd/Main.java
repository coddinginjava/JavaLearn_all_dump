package DS.most_orig.level2.bst_1.seoncd;

public class Main {

    public static void main(String[] args) {
        MyBST bst = new MyBST();
        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(10);
        bst.insert(2);


//		System.out.println("done");

//		System.out.println(bst.find(3));

//		bst.traverserPretOrder();

//		bst.traverserInOrder();

//		bst.traverserPostOrder();

//		System.out.println(bst.height());  //height is 3 for the above input remove 2 to get 2;

//		System.out.println(bst.BSTmin());

//		System.out.println(bst.max());

//		MyBST bst2 = new MyBST();
//
//		bst2.insert(7);
//		bst2.insert(4);
//		bst2.insert(9);
//		bst2.insert(1);
//		bst2.insert(6);
//		bst2.insert(8);
//		bst2.insert(10);
////		bst2.insert(11);
//		bst2.insert(2);
//
//		System.out.println(bst.equals(bst2));

//		bst.swapRoot(); grpc
//		System.out.println(bst.isBinarySearhTree());

//		System.out.println(bst.getNodeAtDistance(3));

		bst.levelOrderTraversal();


    }
}
