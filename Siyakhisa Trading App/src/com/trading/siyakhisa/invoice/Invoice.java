/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.siyakhisa.invoice;

import com.trading.siyakhisa.client.Client;
import com.trading.siyakhisa.company.Company;
import com.trading.siyakhisa.exception.EmptyFieldException;
import com.trading.siyakhisa.exception.UnknownObjectException;
import com.trading.siyakhisa.service.Service;
import com.trading.siyakhisa.user.User;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Thato Keith Kujwane
 */
public final class Invoice implements Serializable{
    private String invoiceNumber;
    private Client client;
    private Date invoiceDate, dueDate;
    private String issuer;
    private LinkedList<Service> services;

    public Invoice(User issuer) {
        this.issuer = issuer.getName();
    }
    
    public Invoice
    (String invoiceNumber, Client client, Date invoiceDate, Date dueDate, String issuer, LinkedList<Service> services)
    throws EmptyFieldException, UnknownObjectException 
    {
        setInvoiceNumber(invoiceNumber);
        this.client = client;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        setIssuer(issuer);
        setServices(services);
    }

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Invoice(String invoiceNumber, Company c) throws EmptyFieldException, UnknownObjectException {
        setInvoiceNumber(invoiceNumber);
        this.client = new Client(c.getName(), c.getEmailAddress(), c.getPhoneNumber());
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) throws UnknownObjectException, EmptyFieldException {
        if (objectHasContents(invoiceNumber)){
            this.invoiceNumber = invoiceNumber;
        }else {
            throw new EmptyFieldException("Unable to set empty invoice number");
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) throws EmptyFieldException, UnknownObjectException {
        if (objectHasContents(issuer)){
            this.issuer = issuer;
        }else {
            throw new EmptyFieldException("Issuer cannot be identified.");
        }
    }

    public LinkedList<Service> getServices() {
        return services;
    }

    public void setServices(LinkedList<Service> services) throws UnknownObjectException, EmptyFieldException {
        if (objectHasContents(services)){
            this.services = services;
        }else {
            throw new EmptyFieldException("Invoice service list empty");
        }
    }
    
    private boolean objectHasContents(Object sample) throws UnknownObjectException{
        if ((sample instanceof String)){
            String s = (String) sample;
            return !s.isEmpty();
        }else if(sample instanceof LinkedList){
            LinkedList list = (LinkedList) sample;
            return !list.isEmpty();
        }else{
            throw new UnknownObjectException("Unknown object parsed for sampling.");
        }
    }
    
    public double calculateCost(){
        double tot = 0;
        for (Service serv : services){
            
        }
        return tot;
    }
}
