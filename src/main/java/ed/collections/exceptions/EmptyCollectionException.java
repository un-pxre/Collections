package ed.collections.exceptions;

/**
 * {@code EmptyCollectionException} is thrown to indicate that an operation
 * requiring elements in a collection was attempted on an empty collection.
 * This exception is typically used by data structures to signal invalid
 * operations due to emptiness.
 *
 * @author José Azevedo (8240127@estg.ipp.pt) */
public class EmptyCollectionException extends Exception {

    /**
     * Constructs a new {@code EmptyCollectionException} with no detail message. */
    public EmptyCollectionException() {
        super();
    }

    /**
     * Constructs a new {@code EmptyCollectionException} with the specified detail message.
     *
     * @param message the detail message to provide additional context about the exception */
    public EmptyCollectionException(String message) {
        super(message);
    }

}
