package TestDS.DS2.Heap;

public class Heap {

    private int[] items = new int[10];
    public int size = 0;



    public void insert(int item) {
        if (isFull())
            throw new IllegalArgumentException("Array is full");

        items[size++] = item;

        bubbleUp();
    }

    public int remove() {
        int num = items[0];
        items[0] = items[--size];

        bubbleDown();

        return num;
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            swap(index, largerChildIndex(index));
            index = largerChildIndex(index);
        }
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        if (!hasRightChild(index))
            return items[index] > leftChild(index);

        return items[index] > leftChild(index) && items[index] > rightChild(index);

    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }


    private void bubbleUp() {
        int index = size - 1;

        while (index > 0 && items[index] > items[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private boolean isFull() {
        return size == items.length;
    }


//    public void heapify(int[] arr){
//        int lastParentIndex =
//    }
}
