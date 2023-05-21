package com.aninfo.model;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long transactionId;
    public Long cbu;
    public Double amount;
    public String type;

    public Transaction(Long cbu, Double amount, String type) {
        this.amount = amount;
        this.type = type;
        this.cbu = cbu;
    }

    public Transaction() {
    }

    public double getCbu() { return cbu;}

    public double getId() { return transactionId;}

    public void setTransactionId(Long id){
        this.transactionId = id;
    }

    public void depositTransaction(Account account) {
        Double sum = this.amount;
        if (sum <= 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }

        if (sum >= 2000){
            double additional = sum*0.1;
            if ( additional > 500 ){
                additional = 500;
            }
            sum = sum + additional;
        }

        account.setBalance(account.getBalance() + sum);
    }
    public void withdrawTransaction(Account account) {
        if (account.getBalance() < this.amount) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - this.amount);
    }


}