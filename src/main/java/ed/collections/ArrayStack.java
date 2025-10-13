package ed.collections;

import java.util.Arrays;
import ed.collections.exceptions.EmptyCollectionException;

/**
 * {@code ArrayStack} represents an array implementation of a stack.
 * It stores elements in a generic array and supports typical stack
 * operations such as {@code push}, {@code pop}, and {@code peek}.
 * When the internal array becomes full, its capacity is automatically
 * expanded by a fixed expansion factor.
 *
 * @param <T> the type of elements stored in this stack
 * @author José Azevedo (8240127@estg.ipp.pt) */
public class ArrayStack<T> implements StackADT<T> {

    /** constant to represent the default capacity of the array */
    private static final int DEFAULT_CAPACITY = 100;
    /** constant to represent the expanding factor of the array capacity */
    private static final int EXPAND_FACTOR = 2;

    /** int that represents both the number of elements and the next available position in the array */
    private int top;
    /** array of generic elements to represent the stack */
    private T[] stack;

    /** Creates an empty stack using the default constructor. */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty stack using the specified capacity.
     *
     * @param initialCapacity represents the specified capacity
     * @throws IllegalArgumentException if {@code initialCapacity} is less than or equal to zero */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be negative or zero.");
        }

        top = 0;
        stack = (T[]) new Object[initialCapacity];
    }

    /**
     * Expands the capacity of this stack's underlying array when it becomes full.
     * The capacity is multiplied by the expansion factor. */
    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * EXPAND_FACTOR);
    }

    /**
     * Adds the specified element to the top of this stack,
     * expanding the capacity of the stack array if necessary.
     *
     * @param element generic element to be pushed onto stack */
    @Override
    public void push(T element) {
        if (top == stack.length) {
            expandCapacity();
        }

        stack[top++] = element;
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

        top--;
        T result = stack[top];
        stack[top] = null;

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

        return stack[top - 1];
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return boolean true if this stack is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return int number of elements in this stack */
    @Override
    public int size() {
        return top;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return String representation of this stack */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ArrayStack { size = " + size() + ", arrayStack.length = " + stack.length + "\n");

        for (int i = top - 1 ; i >= 0; i--) {
            stringBuilder.append(String.format("\t%d -> %s\n", i + 1, stack[i]));
        }

        return stringBuilder.append("}").toString();
    }

}