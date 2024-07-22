package DS.most_orig.level2.heap_3;

public class MyHeap {
    private int[] items = new int[10];
    private int size;

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = value;
        bubbleUp();
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

    public boolean isFull() {
        return size == items.length;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        int remdVar = items[0];
        items[0] = items[--size];
        bubbleDown();
        return remdVar;
    }

    public void bubbleDown() {
        int index = 0;

        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    public int largerChildIndex(int index) {

        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index) > rightChild(index) ?
                leftChildIndex(index) : rightChildIndex(index);
    }

    public boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        if (!hasRightChild(index))
            return items[index] >= leftChild(index);

        return items[index] >= leftChild(index)
                && items[index] >= rightChild(index);

    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMax(){
        if(isEmpty())
            throw new IllegalStateException();
        return items[0];
    }
}
