package org.kizilay.yusuf.caveatemptor.domain;

import javax.persistence.*;

@Entity
@Table(name = "BILLING_DETAILS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails {

    @Id
    @SequenceGenerator(name = "BILLING_DETAILS_SEQ", sequenceName = "BILLING_DETAILS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILLING_DETAILS_SEQ")
    @Column(name = "BILLING_DETAILS_ID")
    private long billingDetailsId;

    @Column(name = "OWNER")
    private String owner;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BillingDetails(String owner, User user) {
        this.owner = owner;
        this.user = user;
    }

    public BillingDetails(String owner) {
        this.owner = owner;
    }

    public BillingDetails() {

    }
}
