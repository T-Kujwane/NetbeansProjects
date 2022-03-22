/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.siyakhisa.company;

import com.trading.siyakhisa.account.Account;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Thato Keith Kujwane
 */
public final class Company implements Serializable{
    String name, regNumber, vatNumber, phoneNumber, emailAddress;
    Account bankAccout;

    public Company(String name, String regNumber, String vatNumber, String phoneNumber, String emailAddress, Account bankAccout) {
        this.name = name;
        this.regNumber = regNumber;
        this.vatNumber = vatNumber;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.bankAccout = bankAccout;
    }

    public Company(String name, String regNumber, String vatNumber, Account bankAccout) {
        this.name = name;
        this.regNumber = regNumber;
        this.vatNumber = vatNumber;
        this.bankAccout = bankAccout;
    }

    public Company(String name, String regNumber, String vatNumber) {
        this.name = name;
        this.regNumber = regNumber;
        this.vatNumber = vatNumber;
    }

    public Company(String name, String regNumber, String vatNumber, String accountHolder, String bank, 
            String accountNumber, String branchCode, String accountType) 
    {
        this.name = name;
        this.regNumber = regNumber;
        this.vatNumber = vatNumber;
        this.bankAccout = new Account(accountHolder, bank, accountNumber, branchCode, accountType);
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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public Account getBankAccout() {
        return bankAccout;
    }

    public void setBankAccout(Account bankAccout) {
        this.bankAccout = bankAccout;
    }
    
    @Override
    public String toString(){
        return "Company-" + this.name + "%regNumber-" + this.regNumber + "%V.A.T._Number-" + this.vatNumber +
                "%phone-" + this.phoneNumber + "%email-" + this.emailAddress + "%" + this.bankAccout;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.regNumber);
        hash = 37 * hash + Objects.hashCode(this.vatNumber);
        hash = 37 * hash + Objects.hashCode(this.phoneNumber);
        hash = 37 * hash + Objects.hashCode(this.emailAddress);
        hash = 37 * hash + Objects.hashCode(this.bankAccout);
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
        final Company other = (Company) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.regNumber, other.regNumber)) {
            return false;
        }
        if (!Objects.equals(this.vatNumber, other.vatNumber)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.emailAddress, other.emailAddress)) {
            return false;
        }
        return Objects.equals(this.bankAccout, other.bankAccout);
    }
    
}
