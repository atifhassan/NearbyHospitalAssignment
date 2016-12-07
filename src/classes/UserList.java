/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import Exceptions.NullUserException;
import Exceptions.EmptyException;
import Exceptions.FullException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import structures.QueueArrayList;

/**
 *
 * @author Atif Hassan
 */
public class UserList {

    private QueueArrayList<User> userList;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private final String FILE;

    /**
     * creates a new queue and sets file name to default
     */
    public UserList() {
        FILE = "databases/userList.dat";
        userList = new QueueArrayList<>();
    }

    /**
     *
     * @param fileName
     */
    public UserList(String fileName) {
        FILE = fileName;
        try {
            in = new ObjectInputStream(new FileInputStream(fileName));
            userList = (QueueArrayList<User>) in.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param data
     * @throws FullException
     */
    public void addUser(User data) throws FullException {
        userList.Enqueue(data);
    }

    /**
     *
     * @param data
     * @return
     * @throws EmptyException
     * @throws FullException
     */
    public boolean doesUsernameExist(String data) throws EmptyException, FullException {
        boolean exist = false;
        User temp;
        String name;
        for (int count = 0; count < userList.size(); count++) {
            temp = userList.Dequeue();
            name = temp.getUsername();
            
            if (name.matches(data)) {
                exist = true;
            }
            userList.Enqueue(temp);
        }
        return exist;
    }

    /**
     *
     * @param data
     * @return
     * @throws Exception
     */
    public User getUser(String data) throws Exception {
        if (!doesUsernameExist(data)) {
            throw new NullUserException();
        }
        User temp = null;
        String name;
        do {
            temp = userList.Dequeue();
            userList.Enqueue(temp);
            name = temp.getUsername();
        } while (!name.matches(data));
        return temp;
    }

    /**
     *
     * @throws IOException
     */
    public void WriteList() throws IOException {
        out = new ObjectOutputStream(new FileOutputStream(FILE));
        out.writeObject(userList);
    }

    @Override
    public String toString() {
        return userList.toString();
    }
}
