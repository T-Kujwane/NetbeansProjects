/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.client.message;

import java.io.Serializable;

/**
 *
 * @author Thato Keith Kujwane
 */
public class Message implements Serializable{
    private final int authorID;
    private final String text;
    private final int destinationID;

    public Message(int id, String text, int destinationID) {
        this.authorID = id;
        this.text = text;
        this.destinationID = destinationID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public String getText() {
        return text;
    }

    public int getDestinationID() {
        return destinationID;
    }
}
