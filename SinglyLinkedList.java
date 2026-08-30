

public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        Node<E> cur = head;
        StringBuilder res = new StringBuilder();

        while(cur != null) {
            res.append(cur.getElement()).append(" ");
            cur = cur.getNext();
        }

        return res.toString().trim();

    }

    public E removeLast(){
        if(isEmpty()) {
            return null;
        }

        E answer = tail.getElement();

        if(head == tail) {
            head = null;
            tail = null;
            size--;
            return answer;
        }

        Node<E> startPtr = head;

        // continue until we find the second last
        while (startPtr.getNext() != tail) {
            startPtr = startPtr.getNext(); 
        }

        // update tail to that and set the next to null and reduce the size
        tail = startPtr;
        tail.setNext(null);
        size--;

        return answer;
    }

    public void reverse(){       

        if(size == 1) {
            return;
        }


        Node<E> prev = null;
        Node<E> cur = head;

        tail = head;

        while (cur != null){
            // store the next
            Node<E> next = cur.getNext();

            // point the current to the prev
            cur.setNext(prev);

            // set the prev to cur
            prev = cur;
            
            // set cur to next
            cur = next;
        }

        // set the head to the first (last) node
        head = prev;
    }
}