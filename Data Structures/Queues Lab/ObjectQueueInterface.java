public interface ObjectQueueInterface
{
    boolean isEmpty();

    boolean isFull();

    void clear();

    void insert(Object o);

    Object remove();

    Object query();

}
