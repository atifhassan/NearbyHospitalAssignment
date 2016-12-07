/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Exceptions.EmptyException;
import Exceptions.FullException;
import Interfaces.QueueInterface;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author atifm
 * @param <E>
 */
public class QueueArrayList<E> implements Serializable, QueueInterface<E> {

    private int front = 0;
    private int back = 0;
    private final int CAPACITY;
    private int size = 0;
    private E[] list;

    /**
     * creates queue array with default length
     */
    public QueueArrayList() {
        CAPACITY = 10;
        list = (E[]) (new Object[CAPACITY]);
    }

    /**
     *
     * @param size
     */
    public QueueArrayList(int size) {
        CAPACITY = size;
        list = (E[]) (new Object[CAPACITY]);
    }

    /**
     *
     * @param element
     * @throws Exceptions.FullException
     */
    @Override
    public void Enqueue(E element) throws FullException {
        if (isFull()) {
            throw new FullException();
        }
        list[back] = element;
        if (back == CAPACITY) {
            back = 0;
        } else {
            back++;
        }
        size++;
    }

    /**
     * 
     * @return
     * @throws EmptyException 
     */
    @Override
    public E Dequeue() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        E element = list[front];
        list[front] = null;
        if (front == CAPACITY) {
            front = 0;
        } else {
            front++;
        }
        size--;
        return element;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }
}
