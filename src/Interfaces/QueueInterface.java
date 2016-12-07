/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.EmptyException;
import Exceptions.FullException;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public interface QueueInterface<E> {

    /**
     *
     * @param element
     * @throws Exceptions.FullException
     */
    public void Enqueue(E element)throws FullException;

    /**
     *
     * @return 
     * @throws Exceptions.EmptyException 
     */
    public E Dequeue() throws EmptyException;

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
    public int size();
}
