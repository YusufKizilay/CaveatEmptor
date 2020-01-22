package org.kizilay.yusuf.caveatemptor.domain;

import org.kizilay.yusuf.caveatemptor.resource.BidResource;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BIDS")
public class Bid {

    @Id
    @GeneratedValue(generator = "BID_ID_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "BID_ID_GEN", sequenceName ="BID_SEQ" )
    @Column(name = "BID_ID")
    private long bidId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Bid() {
    }

    public Bid(BigDecimal amount, Date createdOn) {
        this.amount = amount;
        this.createdOn = createdOn;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BidResource toResource(){
        return  new BidResource(this.amount, this.createdOn);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
