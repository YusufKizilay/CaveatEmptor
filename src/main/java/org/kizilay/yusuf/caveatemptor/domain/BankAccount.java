package org.kizilay.yusuf.caveatemptor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount extends  BillingDetails {

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "SWIFT")
    private String swift;

    public BankAccount() {
    }

    public BankAccount(String owner, User user, String account, String bankName, String swift) {
        //super(owner, user);
        super(owner);
        this.account = account;
        this.bankName = bankName;
        this.swift = swift;
    }

    public BankAccount(String account, String bankName, String swift) {
        super();
        this.account = account;
        this.bankName = bankName;
        this.swift = swift;
    }

    public BankAccount(String owner,String account, String bankName, String swift) {
        super(owner);
        this.account = account;
        this.bankName = bankName;
        this.swift = swift;

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
}
