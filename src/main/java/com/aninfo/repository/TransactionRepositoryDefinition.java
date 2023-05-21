package com.aninfo.repository;


import com.aninfo.model.Transaction;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.*;
@RepositoryRestResource
public class TransactionRepositoryDefinition implements TransactionRepository {
    private final Collection<Transaction> transactions;
    private Long transactionId;

    public TransactionRepositoryDefinition() {
        this.transactions = new ArrayList<>();
        this.transactionId = 0L;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        transaction.setTransactionId(transactionId);
        transactions.add(transaction);
        this.transactionId++;
        return transaction;
    }

    @Override
    public void deleteTransaction(long transactionId) {
        transactions.removeIf(t -> t.getId() == transactionId);
    }

    @Override
    public Transaction getTransaction(long transactionId){
        for (Transaction transaction : transactions) {
            if (transaction.getId() == transactionId) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByAccount(long cbu) {
        List<Transaction> transactionsByAccount = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getCbu() == cbu) {
                transactionsByAccount.add(transaction);
            }
        }
        return transactionsByAccount;
    }
}
