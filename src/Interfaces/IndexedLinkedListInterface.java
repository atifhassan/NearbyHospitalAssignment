/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.NullElementException;
import Exceptions.OutOfBoundsException;
import Exceptions.RepeatElementException;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public interface IndexedLinkedListInterface<E extends Comparable> extends InteratorInterface<E>{

    /**
     *
     * @param element
     * @param index
     * @throws Exceptions.OutOfBoundsException
     * @throws Exceptions.RepeatElementException
     */
    public void add(E element, int index) throws OutOfBoundsException, RepeatElementException;
    
    /**
     *
     * @param element
     * @param index
     * @throws Exceptions.OutOfBoundsException
     */
    public void set(E element, int index) throws OutOfBoundsException;
    
    /**
     *
     * @param index
     * @return
     * @throws Exceptions.OutOfBoundsException
     */
    public E remove(int index) throws OutOfBoundsException;

    /**
     *
     * @param element
     * @return 
     * @throws Exceptions.NullElementException 
     */
    public int indexOf(E element) throws NullElementException;
    
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
     * @param index
     * @return
     * @throws Exceptions.OutOfBoundsException
     */
    public E get(int index) throws OutOfBoundsException;
    
}
