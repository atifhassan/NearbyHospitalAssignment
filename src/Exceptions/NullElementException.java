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
public class NullElementException extends Exception {

    /**
     * Creates a new instance of <code>NullElement</code> without detail
     * message.
     */
    public NullElementException() {
        super();
    }

    /**
     * Constructs an instance of <code>NullElement</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NullElementException(String msg) {
        super(msg);
    }
}
