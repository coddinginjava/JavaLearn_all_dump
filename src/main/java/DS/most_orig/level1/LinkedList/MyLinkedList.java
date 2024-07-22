package DS.most_orig.level1.LinkedList;

public class MyLinkedList {
    private class Node {
        public Node(int item) {
            this.value = item;
        }

        private int value;
        private Node next;
    }

    private Node first;
    private Node last;
    private int size = 0;

//    public void addFirst(int item) {
//        Node newNode = new Node(item);
//        if (first == null) {
//            first=newNode;
//            last=newNode;
//        }
//        newNode.next = first;
//        first = newNode;
//        size++;
//    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (first == null) {
            first = last = node;
        }
        node.next = first;
        first = node;
        size++;
    }


    public int indexOf(int item) {
        int index = -1;
        Node current = first;

        if (first == null) {
            return index;
        }

        while (current != null) {
            if (current.value == item)
                return index;
            else {
                current = current.next;
                index++;
            }
        }
        return -1;
    }


    public boolean contains(int item) {
        return indexOf(item) > 0;
    }

    public void removeFirst() {
        Node second = first.next;
        first = null;
        first = second;
        size--;
    }

    public void removeLast() {
        if (first == null && last == null)
            try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        if (first == last) {
            first = last = null;
            return;
        }

        Node previous = getPreviousnode(last);

        last = previous;
        last.next = null;
        size--;

    }

    private Node getPreviousnode(Node node) {
        Node current = first;

        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        Node current = first;
        int[] arr = new int[size];
        int i = 0;
        while (current != null) {
            arr[i++] = current.value;
            current = current.next;
        }

        return arr;
    }

    public void reverse() {
        Node previous = first;
        Node current = first.next;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;

    }

    public int getKnodefromEnd(int k) {
        if (first == null)
            throw new IllegalArgumentException();

        Node a = first;
        Node b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null) throw new IllegalArgumentException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }


}
