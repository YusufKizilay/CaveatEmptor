package org.kizilay.yusuf.caveatemptor.resource;

import org.kizilay.yusuf.caveatemptor.domain.CreditCard;

public class CreditCardResource extends BaseResource<CreditCard> {

    private String number;

    private String expMonth;

    private String expYear;

    private String owner;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public CreditCard toDomain() {
        return new CreditCard( this.owner,this.number, this.expMonth, this.expYear);
    }
}
