/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author Atif Hassan
 * @param <E>
 */
public class BSTNode<E extends Comparable<E>> {
    private E data;
    private BSTNode<E> left;
    private BSTNode<E> right;

    /**
     *
     * @param data
     */
    public BSTNode(E data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     *
     * @return
     */
    public E getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public BSTNode<E> getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(BSTNode<E> left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public BSTNode<E> getRight() {
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(BSTNode<E> right) {
        this.right = right;
    }
    
    @Override
    public String toString(){
        String list = "";
        if(getLeft()!=null){
            list += getLeft().toString();
        }
        list += data.toString() + ", ";    
        if(getRight()!=null){
            list += getRight().toString();
        }
        return list;
    }
}
