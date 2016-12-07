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
public class NullUserException extends Exception {

    /**
     *Constructs a new exception with null as its detail message. 
     */
    public NullUserException() {
        super();
    }

    /**
     *
     * @param msg
     */
    public NullUserException(String msg) {
        super(msg);
    }

}
