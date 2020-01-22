package org.kizilay.yusuf.caveatemptor.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.kizilay.yusuf.caveatemptor.domain.Bid;
import org.kizilay.yusuf.caveatemptor.domain.User;

import java.math.BigDecimal;
import java.util.Date;

@JsonRootName("Bid")
public class BidResource extends BaseResource<Bid> {

    @JsonProperty("amount")
    private BigDecimal amount;

    private String bidder;



    public BidResource() {
    }

    public BidResource(BigDecimal amount, Date createdOn) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBidder() {
        return bidder;
    }

    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    @Override
    public Bid toDomain() {
        return new Bid(this.amount,new Date());
    }
}
