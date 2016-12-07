/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author Atif Hassan
 * @param <T>
 */
public class LinkedListNode<T> {

    private T data;
    private LinkedListNode<T> pointer;

    /**
     * creates a new null node
     */
    public LinkedListNode() {
        data = null;
        pointer = null;
    }

    /**
     *
     * @param element
     */
    public LinkedListNode(T element) {
        data = element;
        pointer = null;
    }

    /**
     *
     * @param element
     * @param pointer
     */
    public LinkedListNode(T element, LinkedListNode<T> pointer) {
        data = element;
        this.pointer = pointer;
    }

    /**
     *
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public LinkedListNode<T> getPointer() {
        return pointer;
    }

    /**
     *
     * @param pointer
     */
    public void setPointer(LinkedListNode<T> pointer) {
        this.pointer = pointer;
    }

}
