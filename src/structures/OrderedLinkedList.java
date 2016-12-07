/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Exceptions.EmptyException;
import Exceptions.NullElementException;
import Exceptions.RepeatElementException;
import Interfaces.OrderedLinkedListInterface;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public class OrderedLinkedList<E extends Comparable> implements OrderedLinkedListInterface<E> {

    private LinkedListNode<E> headPointer;
    private LinkedListNode<E> currentPointer;
    private LinkedListNode<E> prevPointer;
    private int count = 0;

    /**
     * starts a linked list with null node
     */
    public OrderedLinkedList() {
        headPointer = null;
    }

    /**
     *
     * @param element
     * @throws Exceptions.RepeatElementException
     */
    @Override
    public void add(E element) throws RepeatElementException{
        if(contains(element)){
            throw new RepeatElementException();
        }
        LinkedListNode<E> newNode = new LinkedListNode<>(element);
        if (isEmpty()) {
            newNode.setPointer(headPointer);
            headPointer = newNode;
        } else {
            currentPointer = headPointer;
            prevPointer = headPointer;
            while (hasNext()) {
                if (element.compareTo(currentPointer.getData()) > 0) {
                    prevPointer = currentPointer;
                    currentPointer = currentPointer.getPointer();
                } else if (headPointer.equals(currentPointer)) {
                    //insert at beginning
                    newNode.setPointer(headPointer);
                    headPointer = newNode;
                    break;
                } else {
                    //insert in before current
                    newNode.setPointer(currentPointer);
                    prevPointer.setPointer(newNode);
                    break;
                }
            }
            //insert at end
            if (currentPointer == null) {
                prevPointer.setPointer(newNode);
            }
        }
        count++;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return headPointer == null;
    }

    @Override
    public String toString() {
        LinkedListNode<E> temp = headPointer;
        String list = "";
        while (temp != null) {
            list += temp.getData() + " ";
            temp = temp.getPointer();
        }
        return list;
    }

    /**
     *
     * @param element
     * @return
     * @throws EmptyException
     * @throws Exceptions.NullElementException
     */
    @Override
    public E remove(E element) throws EmptyException, NullElementException {
        if (isEmpty()) {
            throw new EmptyException("The list is Empty");
        }
        if (!contains(element)) {
            throw new NullElementException("Element does not exist");
        }

        LinkedListNode<E> currentTemp = headPointer;
        E temp = currentTemp.getData();
        if (temp != element) {
            LinkedListNode<E> previous;
            do {
                previous = currentTemp;
                currentTemp = currentTemp.getPointer();
                temp = currentTemp.getData();
            } while (temp != element);
            previous.setPointer(currentTemp.getPointer());
        } else {
            headPointer = headPointer.getPointer();
        }
        count--;
        return temp;
    }

    /**
     *
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        E temp;
        LinkedListNode<E> currentTemp = headPointer;
        boolean contains = false;
        while (currentTemp != null) {
            temp = currentTemp.getData();
            if (temp == element) {
                contains = true;
            }
            currentTemp = currentTemp.getPointer();
        }
        return contains;
    }

    /**
     *
     * @param element
     * @return
     * @throws Exceptions.EmptyException
     * @throws Exceptions.NullElementException
     */
    @Override
    public E get(E element) throws EmptyException, NullElementException {
        if (isEmpty()) {
            throw new EmptyException("The list is Empty");
        }
        if (!contains(element)) {
            throw new NullElementException("Element does not exist");
        }
        LinkedListNode<E> tempPointer = headPointer;
        E temp = tempPointer.getData();
        do {
            tempPointer = tempPointer.getPointer();
            temp = tempPointer.getData();
        } while (temp != element);
        return temp;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return count;
    }

    /**
     *
     */
    @Override
    public void reset() {
        headPointer = null;
        currentPointer = null;
        prevPointer = null;
    }

    /**
     *
     * @return
     */
    @Override
    public E getNext() throws NullElementException{
        if (!hasNext()){
            throw new NullElementException("At the end of List");
        }
        E temp = currentPointer.getPointer().getData();
        currentPointer = currentPointer.getPointer();
        return temp;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return currentPointer != null;
    }

}
