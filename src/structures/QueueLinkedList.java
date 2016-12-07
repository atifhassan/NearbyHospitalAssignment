/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Exceptions.EmptyException;
import Interfaces.QueueUnboundedInterface;
import java.io.Serializable;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public class QueueLinkedList<E> implements Serializable, QueueUnboundedInterface<E> {

    private LinkedListNode<E> front;   // reference to the front of this queue
    private LinkedListNode<E> rear;    // reference to the rear of this queue
    private int size = 0;

    public QueueLinkedList() {
        front = null;
        rear = null;
    }

    @Override
    public void Enqueue(E element) {
        LinkedListNode<E> newNode = new LinkedListNode<>(element);
        if (rear == null) {
            front = newNode;
        } else {
            rear.setPointer(newNode);
        }
        rear = newNode;
        size++;
    }

    @Override
    public E Dequeue() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Dequeue attempted on empty queue.");
        } else {
            E element;
            element = front.getData();
            front = front.getPointer();
            if (front == null) {
                rear = null;
            }
            size--;
            return element;

        }
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }

}
