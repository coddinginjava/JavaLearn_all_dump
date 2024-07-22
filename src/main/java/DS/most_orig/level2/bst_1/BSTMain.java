package DS.most_orig.level2.bst_1;

public class BSTMain {

    public static void main(String[] args) {

        Tree bst = new Tree();

//        bst.insert(7);
//        bst.insert(4);
//        bst.insert(9);
//        bst.insert(1);
//        bst.insert(6);
//        bst.insert(8);
//        bst.insert(10);
//        bst.insert(2);

//		System.out.println("done");

//		System.out.println(bst.find(3));

//		bst.traverserPretOrder();

//		bst.traverserInOrder();

//		bst.traverserPostOrder();

//		System.out.println(bst.height());

//		System.out.println(bst.BSTmin());

//		System.out.println(bst.min());

//		Tree bst2 = new Tree();
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

////		bst.swapRoot();
//		System.out.println(bst.isBinarySearhTree());

//		System.out.println(bst.getNodeAtDistance(0));


//		bst.levelOrderTraversal();

        //added recently
//		boolean isSymmetric = bst.isSymmetric();
//		int min = bst.minHeight();

//
//		System.out.println(bst.countTheNode());


//		iscomplete
		bst.insert(7);

		bst.insert(3);

		bst.insert(1);
		bst.insert(5);

		bst.insert(10);
		bst.insert(8);
		bst.insert(11);
//        System.out.println(bst.isCompelete());
//		System.out.println(bst.sumOfAllNodes());
		System.out.println(bst.sumOfALlLeaf());
    }

}
