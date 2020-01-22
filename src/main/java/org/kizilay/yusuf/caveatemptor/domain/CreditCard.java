package org.kizilay.yusuf.caveatemptor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard extends BillingDetails {

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "EXP_MONTH")
    private String expMonth;

    @Column(name = "EXP_YEAR")
    private String expYear;

    public CreditCard() {
    }

    public CreditCard(String owner, String number, String expMonth, String expYear) {
        super(owner);
        this.number = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public CreditCard(String number, String expMonth, String expYear) {
        super();
        this.number = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public CreditCard(String owner, User user, String number, String expMonth, String expYear) {
        //super(owner, user);
        super(owner);
        this.number = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }
}
