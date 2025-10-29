package com.example.bankingapp;

import com.example.bankingapp.config.AppConfig;
import com.example.bankingapp.model.Account;
import com.example.bankingapp.service.BankService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BankService bankService = context.getBean(BankService.class);
        SessionFactory sf = context.getBean(SessionFactory.class);

        // Insert sample accounts if not already present
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(new Account("Nandini", 10000));
            session.persist(new Account("Aarav", 5000));
            tx.commit();
        }

        // Perform transfer
        try {
            bankService.transferMoney(1, 2, 2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        context.close();
    }
}
