public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);

    boolean removeRight();

    E getLast();
}
