import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected Node<E> firstElement;
    protected int size;
    private linkedListItterator<E> iterat = new linkedListItterator<E>();

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if(current == firstElement) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    protected E getValue(Node<E> eNode) {
        return eNode != null ? eNode.item : null;
    }


    @Override
    public Iterator<E> iterator() {
        return iterat;
    }
    public class linkedListItterator<E> implements Iterator<E> {
        int iteration=0;

        @Override
        public boolean hasNext() {
            return firstElement.next != null && size != 0;
        }

        @Override
        public E next() {
            if(hasNext()){
                if(iteration>0){
                firstElement=firstElement.next; }
                iteration++;
                return (E) firstElement.item;
            }
            return null;
        }
    }
}
