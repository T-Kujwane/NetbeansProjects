/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.siyakhisa.client;

import com.trading.siyakhisa.exception.EmptyFieldException;

/**
 *
 * @author Thato Keith Kujwane
 */
public final class Client {
    private String name;
    private String emailAddress, phoneNumber;

    public Client(String name, String emailAddress, String phoneNumber) throws EmptyFieldException {
        setName(name);
        setEmailAddress(emailAddress);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws EmptyFieldException {
        if (hasContents(name)){
            this.name = name;
        }else {
            throw new EmptyFieldException(generateExceptionMessage("name"));
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) throws EmptyFieldException {
        if (hasContents(emailAddress)){
            this.emailAddress = emailAddress;
        }else {
            throw new EmptyFieldException(generateExceptionMessage("email address"));
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws EmptyFieldException {
        if (hasContents(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else {
            throw new EmptyFieldException(generateExceptionMessage("phone number"));
        }
    }
    
    private String generateExceptionMessage(String input){
        return "Client " + input + " is empty and therefore invalid.";
    }
    
    private boolean hasContents(String s){
        return !s.isEmpty();
    }
}
