/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.siyakhisa.account;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Thato Keith Kujwane
 */
public final class Account implements Serializable{
    private String accountHolder, bank, accountNumber, branchCode, accountType;

    public Account(String accountHolder, String bank, String accountNumber, String branchCode, String accountType) {
        this.accountHolder = accountHolder;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.branchCode = branchCode;
        this.accountType = accountType;
    }

    public Account() {
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account-" + this.accountNumber +"%Holder-" + this.accountHolder + "type-" + this.accountType + 
                "bank-" + this.bank + "branch_code-" + this.branchCode;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.accountHolder);
        hash = 89 * hash + Objects.hashCode(this.bank);
        hash = 89 * hash + Objects.hashCode(this.accountNumber);
        hash = 89 * hash + Objects.hashCode(this.branchCode);
        hash = 89 * hash + Objects.hashCode(this.accountType);
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.accountHolder, other.accountHolder)) {
            return false;
        }
        if (!Objects.equals(this.bank, other.bank)) {
            return false;
        }
        if (!Objects.equals(this.accountNumber, other.accountNumber)) {
            return false;
        }
        if (!Objects.equals(this.branchCode, other.branchCode)) {
            return false;
        }
        return Objects.equals(this.accountType, other.accountType);
    }
    
    
}
