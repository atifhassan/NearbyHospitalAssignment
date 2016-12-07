/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.EmptyException;
import Exceptions.NullElementException;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public interface BSTInterface<E extends Comparable<E>> {

    /**
     *
     * @param element
     */
    public void Add(E element);

    /**
     *
     * @param element
     * @return
     * @throws EmptyException
     * @throws Exceptions.NullElementException
     */
    public E Remove(E element) throws EmptyException, NullElementException;

    /**
     *
     * @param element
     * @return
     */
    public boolean Contains(E element);

    /**
     *
     * @return
     */
    public boolean isEmpty();

    /**
     *
     * @return
     */
    public int Size();

    /**
     *
     * @param element
     * @return
     * @throws EmptyException
     * @throws Exceptions.NullElementException
     */
    public E Get(E element) throws EmptyException, NullElementException;

    /**
     *
     */
    public void Reset();

    /**
     *
     * @return
     * @throws EmptyException
     */
    public E getNext() throws EmptyException;
}
