public interface IDeque<E> extends Queue<E> {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    boolean removeRight();
}