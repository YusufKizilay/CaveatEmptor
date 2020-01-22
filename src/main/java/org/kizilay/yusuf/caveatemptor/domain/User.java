package org.kizilay.yusuf.caveatemptor.domain;

import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class    User {

    @Id
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY  )
    //@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    //@JoinColumn(name = "USER_ID")
    private Set<BillingDetails> billingDetails = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Bid> bids = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Item> items = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "HOME_ADR_ID")
    private Address homeAddress;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "BILLING_ADR_ID")
    private Address billingAddress;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SHIPPING_ADR_ID")
    private Address shippingAddress;

    public User() {
    }

    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<BillingDetails> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Set<BillingDetails> billingDetails) {
        this.billingDetails = billingDetails;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
