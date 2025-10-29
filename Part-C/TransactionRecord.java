package com.example.bankingapp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_record")
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Column(name = "from_account")
    private int fromAccount;

    @Column(name = "to_account")
    private int toAccount;

    @Column(name = "amount")
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public TransactionRecord() {}

    public TransactionRecord(int fromAccount, int toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction [ID=" + transactionId + ", From=" + fromAccount + ", To=" + toAccount + ", Amount=" + amount + ", Date=" + date + "]";
    }
}
