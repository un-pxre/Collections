package ed.collections;

import ed.collections.exceptions.EmptyCollectionException;

/**
 * {@code LinkedStack} represents a linked-node implementation of a stack.
 * It uses {@link LinearNode} objects to store elements, with each new element
 * added to the top of the list.
 *
 * @param <T> the type of elements stored in this stack
 * @author José Azevedo (8240127@estg.ipp.pt) */
public class LinkedStack<T> implements StackADT<T> {

    /** int that represents the number of elements in this stack */
    private int size;
    /** reference to the first node in list, which stores the top element of this stack */
    private LinearNode<T> top;

    /** Creates an empty stack using the default constructor. */
    public LinkedStack() {
        size = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     *
     * @param element generic element to be pushed onto stack */
    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        newNode.setNext(top);
        top = newNode;

        size++;
    }

    /**
     * Removes the element at the top of this stack and
     * returns a reference to it.
     * Throws an EmptyCollectionException if the stack is empty.
     *
     * @return T element removed from top of stack
     * @throws EmptyCollectionException if a pop is attempted
     * on empty stack */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }

        T result = top.getElement();
        top = top.getNext();

        size--;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * Throws an EmptyCollectionException if the stack is empty.
     *
     * @return T element on top of stack
     * @throws EmptyCollectionException if a peek is attempted
     * on empty stack */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }

        return top.getElement();
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return boolean {@code true} if this stack is empty, {@code false} otherwise. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return int number of elements in this stack */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return String representation of this stack */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkedStack { size = " + size + "\n");

        int i = size;
        LinearNode<T> current = top;
        while (current != null) {
            stringBuilder.append(String.format("\t%d -> %s\n", i--, current.getElement()));
            current = current.getNext();
        }

        return stringBuilder.append("}").toString();
    }

}
