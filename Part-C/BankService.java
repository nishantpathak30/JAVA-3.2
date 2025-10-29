package com.example.bankingapp.service;

import com.example.bankingapp.dao.*;
import com.example.bankingapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Account fromAccount = accountDAO.getAccount(fromId);
        Account toAccount = accountDAO.getAccount(toId);

        if (fromAccount == null || toAccount == null) {
            throw new RuntimeException("❌ One of the accounts does not exist!");
        }

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("❌ Insufficient balance in source account!");
        }

        // Debit and credit
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        // Update accounts
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);

        // Log transaction
        TransactionRecord record = new TransactionRecord(fromId, toId, amount);
        transactionDAO.saveTransaction(record);

        System.out.println("✅ Transaction Successful!");
    }
}
