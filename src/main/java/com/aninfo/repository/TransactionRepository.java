package com.aninfo.repository;

import com.aninfo.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Transaction createTransaction(Transaction transaction);

    void deleteTransaction(long transactionId);
    Transaction getTransaction(long transactionId);
    List<Transaction> getTransactionsByAccount(long cbu);
}