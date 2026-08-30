
public class SinglyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);

        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString() {
        Node<E> current = head;

        String res = "";

        while (current != null) {
            res += current.getElement().toString();
            current = current.getNext();
        }

        return res;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        E answer = tail.getElement();

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return answer;
        }

        Node<E> current = head;

        while (current.getNext() != tail) {
            current = current.getNext();
        }

        tail = current;
        tail.setNext(null);
        size--;

        return answer;
    }

    public void reverse() {
        Node<E> prev = null;
        Node<E> cur = head;

        // Old head becomes new tail
        tail = head;

        while (cur != null) {
            Node<E> next = cur.getNext();

            cur.setNext(prev);

            prev = cur;
            cur = next;
        }

        // Old tail becomes new head
        head = prev;
    }
}
