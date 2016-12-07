/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Exceptions.NullElementException;
import Exceptions.OutOfBoundsException;
import Exceptions.RepeatElementException;
import Interfaces.IndexedLinkedListInterface;

/**
 *
 * @author atifm
 * @param <E>
 */
public class IndexedLinkedList<E extends Comparable> implements IndexedLinkedListInterface<E> {

    private LinkedListNode<E> headPointer;
    private LinkedListNode<E> currentPointer;
    private LinkedListNode<E> prevPointer;
    private int count = 0;

    /**
     * 
     * @param element
     * @param index
     * @throws OutOfBoundsException
     * @throws RepeatElementException 
     */
    @Override
    public void add(E element, int index) throws OutOfBoundsException, RepeatElementException {
        if (index > size()) {
            throw new OutOfBoundsException("The index is larger than list");
        } else if(contains(element)){
            throw new RepeatElementException();
        }else {
            LinkedListNode<E> newNode = new LinkedListNode<>(element);
            currentPointer = headPointer;
            prevPointer = headPointer;
            if (index == 0) {
                newNode.setPointer(currentPointer);
                headPointer = newNode;
            } else {

                int cnt = 0;
                while (hasNext()) {
                    if (cnt == index) {
                        newNode.setPointer(currentPointer);
                        prevPointer.setPointer(newNode);
                        break;
                    } else { //advance pointer
                        prevPointer = currentPointer;
                        currentPointer = currentPointer.getPointer();
                        cnt++;
                    }
                }
            }
        }
        count++;
    }

    @Override
    public void set(E element, int index) throws OutOfBoundsException {
        if (index > size()) {
            throw new OutOfBoundsException("The index is larger than list");
        } else {
            currentPointer = headPointer;
            prevPointer = headPointer;
            if (index == 0) {
                headPointer.setData(element);
            } else {
                int cnt = 0;
                while (hasNext()) {
                    if (cnt == index) {
                        currentPointer.setData(element);
                        break;
                    } else { //advance pointer
                        prevPointer = currentPointer;
                        currentPointer = currentPointer.getPointer();
                        cnt++;
                    }
                }
            }
        }
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) throws OutOfBoundsException {
        if (index > size()) {
            throw new OutOfBoundsException("The index is larger than list");
        }
        currentPointer = headPointer;
        prevPointer = headPointer;
        E temp = null;

        if (index == 0) {
            temp = headPointer.getData();
        } else {
            int cnt = 0;
            while (hasNext()) {
                if (cnt == index) {
                    temp = currentPointer.getData();
                    break;
                } else { //advance pointer
                    prevPointer = currentPointer;
                    currentPointer = currentPointer.getPointer();
                    cnt++;
                }
            }
        }
        prevPointer.setPointer(currentPointer.getPointer());
        count--;
        return temp;
    }

    @Override
    public int indexOf(E element) throws NullElementException {
        if (!contains(element)) {
            throw new NullElementException();
        }
        int index = 0;
        currentPointer = headPointer;
        prevPointer = headPointer;
        E temp = null;
        int cnt = 0;
        while (hasNext()) {
            temp = currentPointer.getData();
            if (temp.equals(element)) {
                index = cnt;
                break;
            } else { //advance pointer
                prevPointer = currentPointer;
                currentPointer = currentPointer.getPointer();
                cnt++;
            }
        }
        return index;
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) throws OutOfBoundsException {
        if (index > size()) {
            throw new OutOfBoundsException("The index is larger than list");
        }
        currentPointer = headPointer;
        prevPointer = headPointer;
        E temp = null;

        if (index == 0) {
            temp = headPointer.getData();
        } else {
            int cnt = 0;
            while (hasNext()) {
                if (cnt == index) {
                    temp = currentPointer.getData();
                    break;
                } else { //advance pointer
                    prevPointer = currentPointer;
                    currentPointer = currentPointer.getPointer();
                    cnt++;
                }
            }
        }
        return temp;
    }

    @Override
    public boolean contains(E element) {
        boolean contains = false;
        currentPointer = headPointer;
        prevPointer = headPointer;
        E temp;
        for (int cnt = 0; cnt < size(); cnt++) {
            temp = currentPointer.getData();
            if (temp == element) {
                contains = true;
            } else { //advance pointer
                prevPointer = currentPointer;
                currentPointer = currentPointer.getPointer();
            }
        }
        return contains;
    }

    @Override
    public boolean isEmpty() {
        return headPointer == null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void reset() {
        headPointer = null;
        currentPointer = null;
        prevPointer = null;
    }

    @Override
    public E getNext() throws NullElementException {
        if (!hasNext()) {
            throw new NullElementException("At the end of List");
        }
        E temp = currentPointer.getPointer().getData();
        currentPointer = currentPointer.getPointer();
        return temp;
    }

    @Override
    public boolean hasNext() {
        return currentPointer != null;
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
}
