package ed.collections;

import ed.collections.exceptions.EmptyCollectionException;

/**
 * The {@code LinkedQueue} class provides a linked-node implementation of the
 * {@link QueueADT} interface. This queue stores elements in a FIFO (First-In-First-Out)
 * order, where new elements are added at the rear and removed from the front.
 * Internally, the queue is represented using linked {@link LinearNode} objects.
 * The {@code front} node refers to the first element in the queue, and the
 * {@code rear} node refers to the last element.
 * All operations (enqueue, dequeue, first, size, isEmpty) run in constant
 * time O(1).
 *
 * @param <T> the type of elements stored in this queue
 * @author José Azevedo (8240127@estg.ipp.pt) */
public class LinkedQueue<T> implements QueueADT<T> {

    /** int that represents the number of elements currently stored in this queue */
    private int size;

    /** reference to the first node in the queue, which contains the element
     * at the front of this queue */
    private LinearNode<T> front;
    /** reference to the last node in the queue, which contains the element
     * at the rear of the queue */
    private LinearNode<T> rear;

    /** Creates an empty queue using the default constructor. */
    public LinkedQueue() {
        size = 0;
        front = rear = null;
    }

    /**
     * Adds the specified element to the rear of this queue.
     *
     * @param element the element to be added to the queue */
    @Override
    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }

        rear = newNode;

        size++;
    }

    /**
     * Removes and returns the element at the front of this queue.
     * Throws an EmptyCollectionException if the queue is empty.
     *
     * @return the element removed from the front of the queue
     * @throws EmptyCollectionException if the queue is empty */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }

        T result = front.getElement();

        front = front.getNext();

        size--;

        if (isEmpty()) {
            rear = null;
        }

        return result;
    }

    /**
     * Returns, without removing, the element at the front of this queue.
     * Throws an EmptyCollectionException if the queue is empty.
     *
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }

        return front.getElement();
    }

    /**
     * Checks whether this queue contains no elements.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements currently stored in this queue.
     *
     * @return the number of elements in this queue */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this queue.
     * The string includes the current size and the ordered list of elements.
     *
     * @return a string representation of this {@code LinkedQueue} */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkedQueue{ size = " + size + "\n");

        LinearNode<T> current = front;
        int i = 1;
        while (current != null) {
            stringBuilder.append(String.format("\t%d -> %s\n", i++, current.getElement()));
            current = current.getNext();
        }

        return stringBuilder.append("}").toString();
    }

}