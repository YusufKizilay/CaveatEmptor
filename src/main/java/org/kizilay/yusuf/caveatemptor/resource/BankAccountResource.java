package org.kizilay.yusuf.caveatemptor.resource;

import org.kizilay.yusuf.caveatemptor.domain.BankAccount;

public class BankAccountResource extends BaseResource<BankAccount> {
    private String account;

    private String bankName;

    private String swift;

    private String owner;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public BankAccount toDomain() {
        return new BankAccount(this.owner,this.account,this.bankName, this.swift);
    }
}
