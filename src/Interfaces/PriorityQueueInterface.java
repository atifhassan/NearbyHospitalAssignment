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
public interface PriorityQueueInterface<E extends Comparable<E>> {

    /**
     *
     * @return
     */
    public boolean isEmpty();
    // Returns true if this priority queue is empty; otherwise, returns false.

    /**
     *
     * @param element
     */
    public void enqueue(E element);
    // Precondition: element is Comparable
    //
    // Throws PriQOverflowException if this priority queue is full;
    // otherwise, adds element to this priority queue.

    /**
     *
     * @return
     * @throws EmptyException
     */
    public E dequeue() throws EmptyException;
    // Throws PriQUnderflowException if this priority queue is empty;
    // otherwise, removes element with highest priority from this 
    // priority queue and returns it.
}
