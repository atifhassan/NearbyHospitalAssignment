/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.EmptyException;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public interface StackInterface<E> {

    /**
     *
     * @param element
     */
    public void push(E element);

    /**
     *
     * @return
     * @throws Exceptions.EmptyException
     */
    public E pop() throws EmptyException;
    /**
     *
     * @return
     * @throws Exceptions.EmptyException
     */
    public E top() throws EmptyException;

    /**
     *
     * @return
     */
    public boolean isEmpty();

    /**
     *
     * @return
     */
    public boolean isFull();

    /**
     *
     * @return
     */
    public int Size();
}
