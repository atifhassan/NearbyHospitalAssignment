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
public interface QueueUnboundedInterface<E> {

    /**
     *
     * @param element
     */
    public void Enqueue(E element);

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
    public int size();
}
