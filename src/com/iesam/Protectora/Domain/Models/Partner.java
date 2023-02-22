package com.iesam.Protectora.Domain.Models;

public class Partner extends Person{

    private String BankAcc;

    public String getBankAcc() {
        return BankAcc;
    }

    public void setBankAcc(String bankAcc) {
        BankAcc = bankAcc;
    }
}
