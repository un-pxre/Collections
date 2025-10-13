package ed.collections.exceptions;

/**
 * {@code NoSuchElementException} is thrown to indicate that an operation
 * requiring a specified element in a collection was attempted on a collection
 * which did not contain said element.
 * This exception is used by data structures to signal invalid operations
 * due to the lack of a specific element.
 *
 * @author José Azevedo (8240127@estg.ipp.pt) */
public class NoSuchElementException extends Exception {

    /**
     * Constructs a new {@code NoSuchElementException} with no detail message. */
    public NoSuchElementException() {
        super();
    }

    /**
     * Constructs a new {@code NoSuchElementException} with the specified detail message.
     *
     * @param message the detail message to provide additional context about the exception */
    public NoSuchElementException(String message) {
        super(message);
    }

}

