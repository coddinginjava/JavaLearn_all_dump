package DS.study.LL;

public class LL {

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }


    private class Node {
        private final Integer value;
        private Node next;

        public Node(Integer item) {
            this.value = item;
        }

        @Override
        public String toString() {
            return "value -> " + value;
        }
    }

    private Node first;
    private Node last;
    private int count;

    public void addFirst(Integer item) {
        Node newNode = new Node(item);
        if (isEmpty())
            first = last = newNode;
        newNode.next = first;
        first = newNode;
        count++;
    }

    public void addLast(Integer item) {
        Node newNode = new Node(item);

        if (isEmpty())
            first = last = newNode;
        last.next = newNode;
        last = newNode;
        count++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new IllegalArgumentException();
        if (first == last)
            first = last = null;
        else {
            Node temp = first.next;
            first.next = null;
            first = temp;
        }
        count--;
    }

    public void removeLast() {

        if (isEmpty())
            throw new IllegalArgumentException();

        if (first == last) {
            first = last = null;
            return;
        } else {
            Node prev = getPreviousNode(last);
            prev.next = null;
            last = prev;
        }
        count--;
    }

    private Node getPreviousNode(Node node) {
        Node current = first;
        while (current != node) {
            if (current.next == null) break;
            current = current.next;
        }
        return current;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;

        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int[] toArray() {
        if (isEmpty())
            return new int[0];

        int[] arr = new int[count];
        Node current = first;

        for (int i = 0; i < count; i++) {
            arr[i] = current.value;
            current = current.next;
        }
        return arr;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }

    public void reverse() {
        if (isEmpty())
            return;

        Node current = first.next;
        Node pre = first;

        while (current != null) {
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        last = first;
        first.next = null;

        first = pre;
    }

    public int getKthNodeFromEnd(int item) {
        if (isEmpty())
            throw new IllegalArgumentException();

        if (item > count)
            throw new IllegalArgumentException();


        Node a = first;
        Node b = first;

        for (int i = 0; i < item - 1; i++) {
            b = b.next;
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }


}
