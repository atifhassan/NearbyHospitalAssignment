/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.EmptyException;
import Exceptions.NullElementException;
import Exceptions.RepeatElementException;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public interface OrderedLinkedListInterface<E extends Comparable> extends InteratorInterface<E> {

    /**
     *
     * @param element
     * @throws Exceptions.RepeatElementException
     */
    public void add(E element) throws RepeatElementException;

    /**
     *
     * @param element
     * @return
     * @throws EmptyException
     * @throws Exceptions.NullElementException
     */
    public E remove(E element) throws EmptyException, NullElementException;

    /**
     *
     * @param element
     * @return
     */
    public boolean contains(E element);

    /**
     *
     * @return
     */
    public boolean isEmpty();

    /**
     *
     * @return
     */
    public int size();

    /**
     *
     * @param element
     * @return
     * @throws Exceptions.EmptyException
     * @throws Exceptions.NullElementException
     */
    public E get(E element) throws EmptyException, NullElementException;
}
