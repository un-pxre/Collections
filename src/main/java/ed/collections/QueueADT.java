package ed.collections;

import ed.collections.exceptions.EmptyCollectionException;

/**
 * {@code QueueADT} defines the basic operations of a generic queue
 * abstract data type (ADT), including methods for adding, removing,
 * and inspecting elements.
 *
 * @param <T> the type of elements stored in this queue
 * @author José Azevedo (8240127@estg.ipp.pt) */
public interface QueueADT<T> {

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to
     * the rear of this queue */
    public void enqueue(T element);

    /**
     * Removes and returns the element at the front of
     * this queue.
     *
     * @return the element at the front of this queue
     * @throws EmptyCollectionException if the queue is empty */
    public T dequeue() throws EmptyCollectionException;

    /**
     * Returns without removing the element at the front of
     * this queue.
     *
     * @return the first element in this queue
     * @throws EmptyCollectionException if the queue is empty */
    public T first() throws EmptyCollectionException;

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty, false otherwise */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size
     * of this queue */
    public int size();

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue */
    public String toString();

}