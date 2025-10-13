package ed.collections.candidates;

/*
* Faltam @throws in javadoc comments
*
* Iterator deve retornar EmptyCollectionException?
*
* Em que métodos devo incluir o EmptyCollectionException para manter consistência entre coleções
* Por exemplo no contains??
*
* Devo dar publicidade ao facto dos construtores de ArrayADTs com initialCapacity poderem dar throw a IllegalArgumentException?
* */

import java.util.Iterator;

import ed.collections.exceptions.NoSuchElementException;
import ed.collections.exceptions.EmptyCollectionException;

public interface ListADT<T> extends Iterable<T> {

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list */
    public T removeFirst () throws EmptyCollectionException;

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list */
    public T removeLast () throws EmptyCollectionException;

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     * @return the specified element from this list */
    public T remove (T element) throws EmptyCollectionException, NoSuchElementException;

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list */
    public T first() throws EmptyCollectionException;

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list */
    public T last () throws EmptyCollectionException;

    /**
     * Returns true if this list contains the specified target
     * element.
     *
     * @param target the target that is being sought in the list
     * @return true if this list contains the specified target, false otherwise*/
    public boolean contains (T target);

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of the number of
     * elements in this list */
    public int size();

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list */
    @Override
    public Iterator<T> iterator();

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list */
    @Override
    public String toString();

}
