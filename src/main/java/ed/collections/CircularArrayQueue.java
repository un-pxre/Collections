package ed.collections;

import ed.collections.exceptions.EmptyCollectionException;

/**
 * The {@code CircularArrayQueue} class provides an array-based implementation
 * of the {@link QueueADT} interface using a circular array. This queue
 * maintains elements in a FIFO (First-In-First-Out) order, where new elements
 * are added to the rear and removed from the front.
 * When the array reaches its full capacity, it is automatically expanded
 * by a fixed expansion factor. The circular logic ensures that enqueue and
 * dequeue operations both run in constant time O(1).
 *
 * @param <T> the type of elements stored in this queue
 * @author José Azevedo (8240127@estg.ipp.pt) */
public class CircularArrayQueue<T> implements QueueADT<T> {

    /** constant to represent the default capacity of the array */
    private static final int DEFAULT_CAPACITY = 10;
    /** constant to represent the expanding factor of the array capacity */
    private static final int EXPAND_FACTOR = 2;

    /** int that represents the number of elements currently stored in this queue */
    private int size;
    /** int that represents the index of the element at the front of the queue. */
    private int front;
    /** int that represents the index of the next available position at the rear of the queue */
    private int rear;
    /** the array of generic elements used to represent the queue. */
    private T[] queue;

    /** Creates an empty queue with the default capacity. */
    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty queue with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the underlying array
     * @throws IllegalArgumentException if {@code initialCapacity} is less than or equal to zero */
    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be negative or zero.");
        }

        size = front = rear = 0;
        queue = (T[]) new Object[initialCapacity];
    }

    /**
     * Expands the capacity of this queue when the underlying array is full.
     * The new capacity is determined by multiplying the current length by
     * {@link #EXPAND_FACTOR}.
     * All elements are copied to the new array in their logical order,
     * starting from the current {@code front} position. */
    private void expandCapacity() {
        CircularArrayQueue<T> tmpQueue = new CircularArrayQueue<>(queue.length * EXPAND_FACTOR);
        while (!isEmpty()) {
            try {
                tmpQueue.enqueue(this.dequeue());
            } catch (EmptyCollectionException e) {}
        }

        queue = tmpQueue.queue;
        size = tmpQueue.size;
        front = 0;
        rear  = size;
    }

    /**
     * Adds the specified element to the rear of this queue.
     * Expands the internal capacity if the queue is full.
     *
     * @param element the element to be added to the queue */
    @Override
    public void enqueue(T element) {
        if (size == queue.length) {
            expandCapacity();
        }

        queue[rear] = element;

        rear = (rear + 1) % queue.length;

        size++;
    }

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element removed from the front of the queue
     * @throws EmptyCollectionException if the queue is empty */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }

        T result = queue[front];

        front = (front + 1) % queue.length;

        size--;

        return result;
    }

    /**
     * Returns, without removing, the element at the front of this queue.
     *
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }

        return queue[front];
    }

    /**
     * Checks whether this queue contains no elements.
     *
     * @return {@code true} if this queue is empty, {@code false} otherwise */
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
     * The string includes the current size, array capacity,
     * and a list of the elements in logical order.
     *
     * @return a string representation of this queue */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CircularArrayQueue{ size = " + size() + ", arrayQueue.length = " + queue.length + "\n");

        for (int i = 0 ; i < size; i++) {
            stringBuilder.append(String.format("\t%d -> %s\n", i + 1, queue[(front + i) % queue.length]));
        }

        return stringBuilder.append("}").toString();
    }

}