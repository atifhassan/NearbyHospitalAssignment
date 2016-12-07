/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.NullElementException;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public interface InteratorInterface<E extends Comparable> {

    /**
     *Reset all pointer and clear list
     */
    public void reset();

    /**
     *
     * @return
     * @throws Exceptions.NullElementException
     */
    public E getNext() throws NullElementException;

    /**
     *
     * @return
     */
    public boolean hasNext();
}
