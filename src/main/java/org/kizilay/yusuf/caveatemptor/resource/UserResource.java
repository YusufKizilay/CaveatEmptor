package org.kizilay.yusuf.caveatemptor.resource;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.kizilay.yusuf.caveatemptor.domain.BankAccount;
import org.kizilay.yusuf.caveatemptor.domain.CreditCard;
import org.kizilay.yusuf.caveatemptor.domain.User;

import java.util.HashSet;
import java.util.Set;

@JsonRootName("user")
public  class UserResource extends BaseResource<User> {

    private String username;

    private String firstname;

    private String lastname;

    private AddressResource homeAdr;

    private AddressResource billingAdr;

    private AddressResource shippingAdr;

    private Set<CreditCardResource> creditCards=new HashSet<>();

    private Set<BankAccountResource> bankAccounts=new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public AddressResource getHomeAdr() {
        return homeAdr;
    }

    public void setHomeAdr(AddressResource homeAdr) {
        this.homeAdr = homeAdr;
    }

    public AddressResource getBillingAdr() {
        return billingAdr;
    }

    public void setBillingAdr(AddressResource billingAdr) {
        this.billingAdr = billingAdr;
    }

    public AddressResource getShippingAdr() {
        return shippingAdr;
    }

    public void setShippingAdr(AddressResource shippingAdr) {
        this.shippingAdr = shippingAdr;
    }

    public Set<CreditCardResource> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCardResource> creditCards) {
        this.creditCards = creditCards;
    }

    public Set<BankAccountResource> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccountResource> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public User toDomain() {
        User user=new User(this.username, this.firstname, this.lastname);

        user.setBillingAddress(billingAdr.toDomain());
        user.setHomeAddress(homeAdr.toDomain());
        user.setShippingAddress(shippingAdr.toDomain());

        creditCards.stream().forEach(creditCardResource -> {
            CreditCard creditCard=creditCardResource.toDomain();
            creditCard.setUser(user);
            user.getBillingDetails().add(creditCard);
        });
        bankAccounts.stream().forEach(bankAccountResource -> {
            BankAccount bankAccount=bankAccountResource.toDomain();
            bankAccount.setUser(user);
            user.getBillingDetails().add(bankAccount);
        });

        return user;
    }
}
