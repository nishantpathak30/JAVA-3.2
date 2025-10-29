package com.example.bankingapp.dao;

import com.example.bankingapp.model.TransactionRecord;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveTransaction(TransactionRecord record) {
        sessionFactory.getCurrentSession().persist(record);
    }
}
