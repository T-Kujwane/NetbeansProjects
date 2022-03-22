/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.siyakhisa.user;

import com.trading.siyakhisa.client.Client;
import com.trading.siyakhisa.exception.EmptyFieldException;
import com.trading.siyakhisa.exception.UnknownObjectException;
import com.trading.siyakhisa.invoice.Invoice;
import com.trading.siyakhisa.service.Service;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Thato Keith Kujwane
 */
public class User implements Serializable{
    private String name, designation, phoneNumber, emailAddress;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private final File invoices;
    
    public User(String name, String designation, String phoneNumber, String emailAddress, File invoiceRecords) throws IOException {
        this.name = name;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.invoices = invoiceRecords;
        initializeIOStreams();
    }

    public User(String name, String designation, File invoiceRecords) throws IOException {
        this.name = name;
        this.designation = designation;
        this.invoices = invoiceRecords;
        initializeIOStreams();
    }

    private void initializeIOStreams() throws IOException{
        outputStream = new ObjectOutputStream(new FileOutputStream(invoices, true));
        inputStream = new ObjectInputStream(new FileInputStream(invoices));
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.phoneNumber);
        hash = 89 * hash + Objects.hashCode(this.emailAddress);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        return Objects.equals(this.emailAddress, other.emailAddress);
    }

    @Override
    public String toString() {
        return "User-" + name + "%designation-" + this.designation + "%phone-" + this.phoneNumber + 
                "%email-" + this.emailAddress;
    }
    
    public Invoice createInvoice(String invoiceNumber, LinkedList<Service> services, Client client,Date invoiceDate, Date dueDate) 
            throws IOException, EmptyFieldException, UnknownObjectException
    {
        return new Invoice(invoiceNumber, client, invoiceDate, dueDate, name, services);
    }
    
    public Invoice searchForInvoice(String invoice) throws IOException, ClassNotFoundException{
        boolean isDone = false, isFound = false;
        Invoice inv = null;
        do {            
            try{
                Object obj = readFile();
                if (obj instanceof Invoice){
                    Invoice foundInvoice = (Invoice) obj;
                    if (foundInvoice.getInvoiceNumber().equalsIgnoreCase(invoice)){
                        inv = foundInvoice;
                        isFound = true;
                    }
                }
            }catch(EOFException ex){
                isDone = true;
            }
        } while (! (isFound || isDone));
        
        return inv;
    }
    
    public Object readFile() throws IOException, ClassNotFoundException{
        return inputStream.readObject();
    }
    
    public void writeFile(Object writeObject) throws IOException{
        outputStream.writeObject(writeObject);
        outputStream.flush();
    }
    
    public void closeResources() throws IOException{
        outputStream.close();
        inputStream.close();
    }
}
