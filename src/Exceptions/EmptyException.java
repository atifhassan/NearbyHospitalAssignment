/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Atif Hassan
 */
public class EmptyException extends Exception {

    /**
     * Creates a new instance of <code>EmptyException</code> without detail
     * message.
     */
    public EmptyException() {
        super();
    }

    /**
     * Constructs an instance of <code>EmptyException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public EmptyException(String msg) {
        super(msg);
    }
}
