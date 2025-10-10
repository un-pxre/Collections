package ed.collections;

/**
 * {@code LinearNode} represents a single node in a linked structure.
 * Each node stores an element and a reference to the next node in the list.
 *
 * @param <T> the type of element stored in this node
 * @author José Azevedo (8240127@estg.ipp.pt) */
public class LinearNode<T>  {

    /** reference to the next node in list */
    private LinearNode<T> next;
    /** element stored in this node */
    private final T element;

    /** Creates an empty node. */
    public LinearNode() {
        this(null);
    }

    /**
     * Creates a node storing the specified element.
     *
     * @param element element to be stored */
    public LinearNode(T element) {
        next = null;
        this.element = element;
    }

    /**
     * Returns the node that follows this one.
     *
     * @return LinearNode&lt;T>&lt; reference to next node */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one.
     *
     * @param next node to follow this one */
    public void setNext(LinearNode<T> next) {
        this.next = next;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return T element stored in this node */
    public T getElement() {
        return element;
    }

}
