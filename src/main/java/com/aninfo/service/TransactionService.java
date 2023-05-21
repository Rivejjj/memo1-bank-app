package com.aninfo.service;

import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<Transaction> getTransactionsByAccount(long cbu) {
        return repository.getTransactionsByAccount(cbu);
    }

    public Transaction getTransactionById(long transactionId) {
        return repository.getTransaction(transactionId);
    }

    public void deleteTransaction(long transactionId) {
        repository.deleteTransaction(transactionId);
    }

}