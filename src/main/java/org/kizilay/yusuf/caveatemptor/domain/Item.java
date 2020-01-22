package org.kizilay.yusuf.caveatemptor.domain;

import org.kizilay.yusuf.caveatemptor.resource.BidResource;
import org.kizilay.yusuf.caveatemptor.resource.ImageResource;
import org.kizilay.yusuf.caveatemptor.resource.ItemResource;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ITEMS")
public class Item implements Serializable {

    @Id
    @Column(name = "ITEM_ID")
    @SequenceGenerator(name = "ITEM_SEQ", sequenceName = "ITEM_SEQ")
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "ITEM_SEQ")
    private long itemId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "INITIAL_PRICE")
    private BigDecimal initialPrice;

    @Column(name = "AUCTION_END")
    private Date auctionEnd;

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "ITEM_IMAGES",joinColumns = @JoinColumn(name = "ITEM_ID"))
    @Embedded
    private Set<Image> images= new HashSet<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Bid> bids=new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CATEGORY_ITEM", joinColumns = {
            @JoinColumn(name = "ITEM_ID")
    }, inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    private Set<Category> categories = new HashSet<>();

    public Item() {
    }

    public Item(String name, BigDecimal initialPrice, Date auctionEnd) {
        this.name = name;
        this.initialPrice = initialPrice;
        this.auctionEnd = auctionEnd;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

}
