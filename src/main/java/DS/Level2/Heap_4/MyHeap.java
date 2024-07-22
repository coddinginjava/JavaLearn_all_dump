package DS.Level2.Heap_4;

public class MyHeap {
    private int[] items = new int[10];
    private int size = 0;

    public void insert(int val) {
        if (isFull())
            throw new IllegalStateException();
        items[size++] = val;
        bubbleUp();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int remove() {
        int removedItem = items[0];
        items[0] = items[--size];
        bubbleDown();
        return removedItem;
    }

    private void bubbleDown() {
        int index = 0;

        while (index <= size && !isValidParent(index)) {
            int largerIndex = largerChildIndex(index);
            swap(index, largerIndex);
            index = largerIndex;
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

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private void bubbleUp() {
        int index = size - 1;

        while (index > 0 && items[index] > items[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }


    private boolean isFull() {
        return size == items.length;
    }

    public int getMax() {
        return items[0];
    }
}
