

public class LinkedListMultiSet<T> implements MultiSet<T> {
    private class Node<T> {
        public T value;
        public Node<T> next;

        Node(T v) {
            this.value = v;
        }
    }
    private Node<T> front;
    private int size;

    public LinkedListMultiSet() {
        this.front = null;
        this.size = 0;
    }

    /**
     * @param item - item to be added to the multiset
     * @return true if operation is successful
     */
    public boolean add(T item) {
        Node<T> curr = this.front;
        if (curr == null) {
            // front is null
            this.front = new Node<T>(item);
            this.size++;
            return true;
        }

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new Node<T>(item);
        this.size++;
        return true;
    }

    /**
     * @param item - item to remove
     */
    public void remove(T item) {
        Node<T> curr = this.front;
        if (curr == null) {
            // 0 elements in this multiset
            return;
        }

        if (curr.next == null) {
            // 1 element in this multiset
            if (curr.value == item) {
                this.front = curr.next;
                size--;
                return;
            }
        }

        while (curr.next != null) {
            if (curr.next.value == item) {
                curr.next = curr.next.next;
                size--;
                return;
            }
            curr = curr.next;
        }
    }

    /**
     * @param item
     * @return
     */
    public boolean contains(T item) {
        Node<T> curr = this.front;
        if (curr == null) {
            // front is null
            return false;
        }

        while (curr != null) {
            // check each element if the value is item
            if (curr.value == item) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * @return
     */
    public boolean is_empty() {
        return size == 0;
    }

    /**
     * @param item
     * @return
     */
    public int count(T item) {
        Node<T> curr = this.front;
        int count = 0;
        while (curr != null) {
            if (curr.value == item) {
                count += 1;
            }
            curr = curr.next;
        }
        return count;
    }

    /**
     * @return - the number of items in this multiset
     */
    public int size() {
        return this.size;
    }
}
